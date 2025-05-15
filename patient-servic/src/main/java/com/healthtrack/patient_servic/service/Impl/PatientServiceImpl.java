package com.healthtrack.patient_servic.service.Impl;

import com.healthtrack.patient_servic.dto.PatientRequestDTO;
import com.healthtrack.patient_servic.dto.PatientResponseDto;
import com.healthtrack.patient_servic.entity.Patient;
import com.healthtrack.patient_servic.repository.PatientRepository;
import com.healthtrack.patient_servic.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public ResponseEntity<PatientResponseDto> create(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();
        patient.setFirstName(patientRequestDTO.firstName());
        patient.setLastName(patientRequestDTO.lastName());
        patient.setEmail(patientRequestDTO.email());
        patient.setPassword(patientRequestDTO.password());

        Patient savedPatient = patientRepository.save(patient);

        PatientResponseDto responseDto = new PatientResponseDto(savedPatient.getId(), savedPatient.getFirstName(), savedPatient.getLastName(), savedPatient.getEmail(), savedPatient.getPassword() // You may want to exclude password for security reasons
        );

        return ResponseEntity.ok(responseDto);
    }

}
