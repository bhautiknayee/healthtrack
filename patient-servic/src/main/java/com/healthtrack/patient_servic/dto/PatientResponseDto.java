package com.healthtrack.patient_servic.dto;

public record PatientResponseDto(
    String id,
    String firstName,
    String lastName,
    String phoneNumber,
    String email
) {}
