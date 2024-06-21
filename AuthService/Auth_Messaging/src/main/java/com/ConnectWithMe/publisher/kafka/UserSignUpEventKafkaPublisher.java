package com.ConnectWithMe.publisher.kafka;

import com.ConnectWithMe.Domain.config.AuthServiceConfigData;
import com.ConnectWithMe.Domain.outbox.model.UserSignUpEventPayload;
import com.ConnectWithMe.Domain.ports.output.message.publisher.userSignUpRequestMessagePublisher;
import com.ConnectWithMe.kafka.Model.UserSignUpEventAvroPayload;
import com.ConnectWithMe.kafka.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UserSignUpEventKafkaPublisher implements userSignUpRequestMessagePublisher {

    @Autowired
    private KafkaProducer<String, UserSignUpEventAvroPayload> kafkaProducer;

    private AuthServiceConfigData authServiceConfigData;

    @Override
    public void publish(String topicName, String key, UserSignUpEventPayload userSignUpEventPayload){

        System.out.println("userSignUpEventKafkapublisher "+userSignUpEventPayload.getUserID());
        UserSignUpEventAvroPayload avropayload = new UserSignUpEventAvroPayload(userSignUpEventPayload.getUserID() , userSignUpEventPayload.getSkillIDs() , Collections.singletonList(userSignUpEventPayload.getCollegeInfoID()));
        kafkaProducer.send(topicName , String.valueOf(userSignUpEventPayload.getUserID()) , avropayload);
        System.out.println("Done send");
    }
}
