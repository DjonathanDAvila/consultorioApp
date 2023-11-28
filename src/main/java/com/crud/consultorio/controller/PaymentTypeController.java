package com.crud.consultorio.controller;

import com.crud.consultorio.model.PaymentType;
import com.crud.consultorio.repositories.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentType")
public class PaymentTypeController {
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @PostMapping
    public PaymentType paymentTypeRepository(@RequestBody PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }
}
