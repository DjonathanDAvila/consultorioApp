package com.crud.consultorio.controller;

import com.crud.consultorio.DTOs.SchedulingDTO;
import com.crud.consultorio.model.Patient;
import com.crud.consultorio.model.Scheduling;
import com.crud.consultorio.model.Status;
import com.crud.consultorio.model.Test;
import com.crud.consultorio.repositories.IPatientRepository;
import com.crud.consultorio.repositories.ISchedulingRepository;
import com.crud.consultorio.repositories.IStatusRepository;
import com.crud.consultorio.repositories.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduling")
@CrossOrigin(origins = "http://localhost:5173/")
public class SchedulingController {
    @Autowired
    private ISchedulingRepository _schedulingRepository;
    @Autowired
    private IPatientRepository _patientRepository;
    @Autowired
    private ITestRepository _testRepository;
    @Autowired
    private IStatusRepository _statusRepository;

    @PostMapping
    public Scheduling insertScheduling(@RequestBody SchedulingDTO scheduling) {
        Patient patient = _patientRepository.findById(scheduling.getPatientID()).orElse(null);
        Test test = _testRepository.findById(scheduling.getTestID()).orElse(null);
        Status status = _statusRepository.findById(scheduling.getStatusID()).orElse(null);

        Scheduling newScheduling = new Scheduling(null, patient, test, status, scheduling.getDate());

        return _schedulingRepository.save(newScheduling);
    };

    @GetMapping
    public Iterable<Scheduling> getScheduling(){
        return _schedulingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Scheduling getScheduling(@PathVariable int id){
        return _schedulingRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Scheduling updateScheduling(@PathVariable int id, @RequestBody SchedulingDTO scheduling){
        Patient patient = _patientRepository.findById(scheduling.getPatientID()).orElse(null);
        Test test = _testRepository.findById(scheduling.getTestID()).orElse(null);
        Status status = _statusRepository.findById(scheduling.getStatusID()).orElse(null);

        Scheduling newScheduling = new Scheduling(id, patient, test, status, scheduling.getDate());

        return _schedulingRepository.save(newScheduling);
    }

    @DeleteMapping("/{id}")
    public void deleteScheduling(@PathVariable int id){
        _schedulingRepository.deleteById(id);
    }
}
