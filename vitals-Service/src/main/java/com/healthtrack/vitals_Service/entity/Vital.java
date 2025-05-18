package com.healthtrack.vitals_Service.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "vitals")
public class Vital {
    @Id
    private String id;
    private String patientId;
    private int heartRate;
    private int bloodPressure;
    private LocalDateTime timestamp;
}
