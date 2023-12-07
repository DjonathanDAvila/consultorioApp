package com.crud.consultorio.controller;

import com.crud.consultorio.DTOs.ServiceDTO;
import com.crud.consultorio.model.PaymentType;
import com.crud.consultorio.model.Scheduling;
import com.crud.consultorio.model.Service;
import com.crud.consultorio.repositories.ISchedulingRepository;
import com.crud.consultorio.repositories.IServiceRepository;
import com.crud.consultorio.repositories.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "http://localhost:5173/")
public class ServiceController {
    @Autowired
    private IServiceRepository _serviceRepository;

    @Autowired
    private PaymentTypeRepository _paymentTypeRepository;

    @Autowired
    private ISchedulingRepository _schedulingRepository;

    @PostMapping
    public Service insertService(@RequestBody ServiceDTO service) {
        PaymentType paymentType = _paymentTypeRepository.findById(service.getPaymentTypeID()).orElse(null);
        Scheduling scheduling = _schedulingRepository.findById(service.getSchedulingID()).orElse(null);
        Service newService = new Service(null, service.getPrice(), paymentType, scheduling, service.getObs());

        return _serviceRepository.save(newService);
    };

    @GetMapping
    public Iterable<Service> getService(){
        return _serviceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Service getService(@PathVariable int id){
        return _serviceRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Service updateScheduling(@PathVariable int id, @RequestBody ServiceDTO service){
        PaymentType paymentType = _paymentTypeRepository.findById(service.getPaymentTypeID()).orElse(null);
        Scheduling scheduling = _schedulingRepository.findById(service.getSchedulingID()).orElse(null);
        Service newService = new Service(id, service.getPrice(), paymentType, scheduling, service.getObs());

        return _serviceRepository.save(newService);
    }

    @DeleteMapping("/{id}")
    public void deleteScheduling(@PathVariable int id){
        _serviceRepository.deleteById(id);
    }
}
