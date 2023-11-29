package com.crud.consultorio.controller;

import com.crud.consultorio.model.PaymentType;
import com.crud.consultorio.model.Service;
import com.crud.consultorio.repositories.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paymentType")
public class PaymentTypeController {
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @PostMapping
    public PaymentType createPaymentType(@RequestBody PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    @GetMapping
    public Iterable<PaymentType> getAllPaymentTypes(){
        return paymentTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public PaymentType getPaymentTypeById(@PathVariable int id){
        return paymentTypeRepository.findById(id).orElse(null);
    }
}
