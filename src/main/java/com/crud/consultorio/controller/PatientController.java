
package com.crud.consultorio.controller;

import com.crud.consultorio.DTOs.PatientDTO;
import com.crud.consultorio.model.Patient;
import com.crud.consultorio.repositories.IPatientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private IPatientRepository _patientRepository;
    
    @PostMapping
    public Patient insertPatient(@RequestBody PatientDTO patient) {
        Patient newPatient = new Patient(null,
                                        patient.getName(),
                                        patient.getSex(),
                                        patient.getCPF(),
                                        patient.getBornDate());

        return _patientRepository.save(newPatient);
    };
    
    @GetMapping
    public List<Patient> getPatient(){
        return _patientRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable int id){
        return _patientRepository.findById(id).orElse(null);
    }
    
        @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable int id, PatientDTO patient){
        var newPatient = _patientRepository.findById(id).orElse(null);

        if (newPatient!= null){

            newPatient.setName(patient.getName());
            newPatient.setSex(patient.getSex());
            newPatient.setCpf(patient.getCPF());
            newPatient.setBornDate(patient.getBornDate());


            return _patientRepository.save(newPatient);
        }

        return null;
    }
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable int id){
        _patientRepository.deleteById(id);
    }

}
