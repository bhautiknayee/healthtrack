package com.healthtrack.patient_servic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.healthtrack.patient_servic")
public class PatientServicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientServicApplication.class, args);
	}

}
