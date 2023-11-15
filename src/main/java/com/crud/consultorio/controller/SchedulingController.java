package com.crud.consultorio.controller;

import com.crud.consultorio.model.Scheduling;
import com.crud.consultorio.model.Status;
import com.crud.consultorio.repositories.ISchedulingRepository;
import com.crud.consultorio.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {
    @Autowired
    private ISchedulingRepository _schedulingRepository;

    @PostMapping
    public Scheduling insertScheduling(@RequestBody Scheduling scheduling) {
        return _schedulingRepository.save(scheduling);
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
    public Scheduling updateScheduling(@PathVariable int id, Scheduling scheduling){
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
