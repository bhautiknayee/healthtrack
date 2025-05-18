package com.healthtrack.alert_service.service;

import com.healthtrack.alert_service.entity.Vital;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AlertConsumer {

    @KafkaListener(topics = "alerts-topic", groupId = "alert-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumeVitalAlert(Vital vital) {
        System.out.println("🚨 ALERT RECEIVED 🚨");
        System.out.println("Patient ID: " + vital.getId());
        System.out.println("Heart Rate: " + vital.getHeartRate());
        System.out.println("Blood Pressure: " + vital.getBloodPressure());
        System.out.println("Timestamp: " + vital.getTimestamp());

        if (vital.getHeartRate() > 120) {
            System.out.println("❗ High Heart Rate Alert!");
        }

        if (vital.getBloodPressure() > 140) {
            System.out.println("❗ High Blood Pressure Alert!");
        }
    }
}