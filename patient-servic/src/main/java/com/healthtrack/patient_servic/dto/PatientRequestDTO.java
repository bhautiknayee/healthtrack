package com.healthtrack.patient_servic.dto;

public record PatientRequestDTO(String firstName, String lastName, String phoneNumber, String email, String password) {
}
