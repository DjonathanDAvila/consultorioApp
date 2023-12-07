package com.crud.consultorio.controller;


import com.crud.consultorio.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crud.consultorio.repositories.IStatusRepository;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = "http://localhost:5173/")
public class StatusController {
    @Autowired
    private IStatusRepository statusRepository;

    @PostMapping
    public Status insertStatus(@RequestBody Status status) {
        return statusRepository.save(status);
    };

    @GetMapping
    public Iterable<Status> getStatus(){
        return statusRepository.findAll();
    }

    @GetMapping("/{id}")
    public Status getStatus(@PathVariable int id){
        return statusRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Status updateStatus(@PathVariable int id, Status status){
        var newStatus = statusRepository.findById(id).orElse(null);

        if (newStatus != null){

            newStatus.setDescription(status.getDescription());

            return statusRepository.save(newStatus);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable int id){
        statusRepository.deleteById(id);
    }
}


