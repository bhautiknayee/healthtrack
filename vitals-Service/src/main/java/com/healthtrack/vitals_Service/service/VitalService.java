package com.healthtrack.vitals_Service.service;

import com.healthtrack.vitals_Service.entity.Vital;
import org.springframework.http.ResponseEntity;

public interface VitalService {


    ResponseEntity<Vital> save(Vital vital);
}
