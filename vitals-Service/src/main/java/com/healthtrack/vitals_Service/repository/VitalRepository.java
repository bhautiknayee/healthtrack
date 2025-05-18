package com.healthtrack.vitals_Service.repository;

import com.healthtrack.vitals_Service.entity.Vital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitalRepository extends MongoRepository<Vital, String> {
}
