package com.healthtrack.patient_servic.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "patient")
@Data
public class Patient {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String password;

}
