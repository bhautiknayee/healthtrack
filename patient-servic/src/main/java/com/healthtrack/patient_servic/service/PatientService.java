package com.healthtrack.patient_servic.service;

import com.healthtrack.patient_servic.dto.PatientRequestDTO;
import com.healthtrack.patient_servic.dto.PatientResponseDto;
import org.springframework.http.ResponseEntity;

public interface PatientService {
    ResponseEntity<PatientResponseDto> create(PatientRequestDTO patientRequestDTO);
}
