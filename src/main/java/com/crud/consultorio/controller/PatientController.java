package com.crud.consultorio.controller;

import com.crud.consultorio.model.Patient;
import com.crud.consultorio.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public Patient patientRepository(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }
}
