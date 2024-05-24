package com.ConnectWithMe.kafka.service.impl;

import com.ConnectWithMe.kafka.exception.KafkaProducerException;
import com.ConnectWithMe.kafka.service.KafkaProducer;
import jakarta.annotation.PreDestroy;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@Component
public class KafkaProducerImpl<K extends Serializable, V> implements KafkaProducer<K, V> {

    private final KafkaTemplate<K, V> kafkaTemplate;

    public KafkaProducerImpl(KafkaTemplate<K, V> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String topicName, K key, V message) {
        System.out.println("Sending message={} to topic={}" + message + topicName);
        try {
            CompletableFuture<SendResult<K, V>> kafkaResultFuture = kafkaTemplate.send(topicName, key, message);
            kafkaResultFuture.whenComplete((result,ex)->{
                if (ex == null) {
                    System.out.println("Sent message=[" + message +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            message + "] due to : " + ex.getMessage());
                }
            });
        } catch (KafkaException e) {
            System.out.println("Error on kafka producer with key: {}, message: {} and exception: {}"+ key + message + e.getMessage());
            throw new KafkaProducerException("Error on kafka producer with key: " + key + " and message: " + message);
        }
    }

    @PreDestroy
    public void close() {
        if (kafkaTemplate != null) {
            System.out.println("Closing kafka producer!");
            kafkaTemplate.destroy();
        }
    }
}
