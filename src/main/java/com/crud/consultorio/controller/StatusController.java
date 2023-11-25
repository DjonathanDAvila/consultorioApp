package com.crud.consultorio.controller;

import com.crud.consultorio.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.consultorio.repositories.IStatusRepository;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private IStatusRepository statusRepository;

    @PostMapping
    public Status insertStatus(@RequestBody Status satus) {
        return statusRepository.save(satus);
    };
}


