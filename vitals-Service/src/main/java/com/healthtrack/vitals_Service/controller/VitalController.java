package com.healthtrack.vitals_Service.controller;


import com.healthtrack.vitals_Service.entity.Vital;
import com.healthtrack.vitals_Service.service.VitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vitals")
public class VitalController {

    private final VitalService vitalService;

    public VitalController(VitalService vitalService) {
        this.vitalService = vitalService;
    }


    @PostMapping
    public ResponseEntity<Vital> saveVital(@RequestBody Vital vital) {
        return vitalService.save(vital);
    }

}
