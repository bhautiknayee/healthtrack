package com.healthtrack.patient_servic.repository;

import com.healthtrack.patient_servic.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    boolean existsById(String id);
}
