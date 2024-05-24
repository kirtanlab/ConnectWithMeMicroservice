package com.ConnectWithMe.Domain.ports.output.message.publisher;

import com.ConnectWithMe.Domain.outbox.model.UserSignUpEventPayload;

public interface userSignUpRequestMessagePublisher {
    void publish(String topicName , String key , UserSignUpEventPayload userSignUpEventPayload);
}
