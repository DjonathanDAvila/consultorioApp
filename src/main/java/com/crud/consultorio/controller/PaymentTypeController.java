package com.crud.consultorio.controller;

import com.crud.consultorio.DTOs.PaymentTypeDTO;
import com.crud.consultorio.model.PaymentType;
import com.crud.consultorio.model.Status;
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
    public Iterable<PaymentType> gePaymentType(){
        return paymentTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public PaymentType getPaymentType(@PathVariable int id){
        return paymentTypeRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public PaymentType updatePaymentType(@PathVariable int id, @RequestBody PaymentTypeDTO paymentType){
        var newPaymentType = paymentTypeRepository.findById(id).orElse(null);

        if (newPaymentType != null){

            newPaymentType.setType(paymentType.getType());

            return paymentTypeRepository.save(newPaymentType);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePaymentType(@PathVariable int id){
        paymentTypeRepository.deleteById(id);
    }
}
