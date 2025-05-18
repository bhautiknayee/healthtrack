package com.healthtrack.alert_service.entity;

import java.time.LocalDateTime;

public class Vital {

    private String id;
    private String patientId;
    private int heartRate;
    private int bloodPressure;
    private LocalDateTime timestamp;

    // Correct no-argument constructor
    public Vital() {
    }

    // Parameterized constructor
    public Vital(String id, String patientId, int heartRate, int bloodPressure, LocalDateTime timestamp) {
        this.id = id;
        this.patientId = patientId;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
