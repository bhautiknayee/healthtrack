package com.healthtrack.patient_servic.controller;

import com.healthtrack.patient_servic.dto.PatientRequestDTO;
import com.healthtrack.patient_servic.dto.PatientResponseDto;
import com.healthtrack.patient_servic.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Controller is working");
    }

    @PostMapping("/create")
    public ResponseEntity<PatientResponseDto> create(@RequestBody PatientRequestDTO patientRequestDTO) {
        return patientService.create(patientRequestDTO);
    }

}
