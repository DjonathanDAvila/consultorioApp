package com.crud.consultorio.controller;

import com.crud.consultorio.model.Status;
import com.crud.consultorio.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusRepository statusRepository;

    @PostMapping
    public Status insertStatus(@RequestBody Status satus) {
        return statusRepository.save(satus);
    };
}


