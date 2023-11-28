package com.crud.consultorio.controller;

import com.crud.consultorio.DTOs.SchedulingDTO;
import com.crud.consultorio.model.Scheduling;
import com.crud.consultorio.repositories.ISchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {
    @Autowired
    private ISchedulingRepository _schedulingRepository;

    @PostMapping
    public Scheduling insertScheduling(@RequestBody SchedulingDTO scheduling) {
        Scheduling newScheduling = new Scheduling(null, scheduling.getPatient(), scheduling.getTest(), scheduling.getStatus(), scheduling.getDate());

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
    public Scheduling updateScheduling(@PathVariable int id, SchedulingDTO scheduling){
        var newScheduling = _schedulingRepository.findById(id).orElse(null);

        if (newScheduling != null){

            newScheduling.setTest(scheduling.getTest());
            newScheduling.setDate(scheduling.getDate());
            newScheduling.setStatus(scheduling.getStatus());
            newScheduling.setPatient(scheduling.getPatient());


            return _schedulingRepository.save(newScheduling);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteScheduling(@PathVariable int id){
        _schedulingRepository.deleteById(id);
    }
}
