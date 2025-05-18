package com.healthtrack.vitals_Service.service;


import com.healthtrack.vitals_Service.entity.Vital;
import com.healthtrack.vitals_Service.repository.VitalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class VitalServiceImpl implements VitalService {


    private final VitalRepository vitalRepository;
    private final KafkaTemplate<String, Vital> kafkaTemplate;
    private final RestTemplate restTemplate;

    public VitalServiceImpl(VitalRepository vitalRepository, KafkaTemplate<String, Vital> kafkaTemplate, RestTemplate restTemplate) {
        this.vitalRepository = vitalRepository;
        this.kafkaTemplate = kafkaTemplate;
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<Vital> save(Vital vital) {
        vital.setTimestamp(LocalDateTime.now());
        Vital savedVital = vitalRepository.save(vital);

        if (checkVitals(savedVital)) {
            if (isPatientValid(savedVital.getPatientId())) {
                System.out.println("Result is " + isPatientValid(savedVital.getPatientId()));
                kafkaTemplate.send("alerts-topic", savedVital); // send alert to Kafka
            } else {
                System.out.println("PatientId is not valid. Please try again !");
                // Return 400 Bad Request response with a message
                return ResponseEntity.badRequest().body(null);  // or you can create an error object/message if you want
            }
        }

        return new ResponseEntity<>(savedVital, HttpStatus.CREATED);
    }

    public boolean checkVitals(Vital vital) {
        return vital.getHeartRate() > 120 || vital.getBloodPressure() > 140;
    }

    public boolean isPatientValid(String id) {
        String url = "http://localhost:8080/patient-service/api/v1/patient/validate/{id}";
        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class, id);
        return response.getBody() != null && response.getBody();
    }
}
