package com.healthtrack.vitals_Service.service;

import com.healthtrack.vitals_Service.entity.Vital;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class VitalProducer {

    /*
    KafkaTemplate is a helper class from Spring that makes it easy to send messages to Kafka.
    Here, the key is of type String (e.g., patient ID), and the value is of type Vital (your custom POJO).
    It's marked final because it's injected once via constructor and never changes.
     */
    private final KafkaTemplate<String, Vital> kafkaTemplate;

    public VitalProducer(KafkaTemplate<String, Vital> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /*
    This reads the topic name (alerts-topic) from application.properties using Spring’s @Value annotation.
    So if you change the topic name in properties, you don't need to change it in code.
     */
    @Value("${kafka.topic.alerts}")
    private String alertTopic;

    /*
    This method sends a message to Kafka.
    alertTopic: the name of the Kafka topic (from application.properties)
    vital.getPatientId(): used as the message key (helps Kafka partition the data).
    vital: the actual message payload — it will be serialized to JSON and sent to Kafka.
     */

    public void sendVitalData(Vital vital) {
        kafkaTemplate.send(alertTopic, vital.getPatientId(), vital);
    }

}
