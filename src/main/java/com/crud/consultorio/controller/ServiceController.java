package com.crud.consultorio.controller;

import com.crud.consultorio.DTOs.ServiceDTO;
import com.crud.consultorio.model.Service;
import com.crud.consultorio.repositories.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduling")
public class ServiceController {
    @Autowired
    private IServiceRepository _serviceRepository;

    @PostMapping
    public Service insertService(@RequestBody ServiceDTO service) {
        Service newService = new Service(null, service.getPrice(), service.getPaymentType(), service.getScheduling(), service.getObs());

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
    public Service updateScheduling(@PathVariable int id, ServiceDTO service){
        var newService = _serviceRepository.findById(id).orElse(null);

        if (newService != null){

            newService.setPrice(service.getPrice());
            newService.setScheduling(service.getScheduling());
            newService.setPaymentType(service.getPaymentType());
            newService.setObs(service.getObs());


            return _serviceRepository.save(newService);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteScheduling(@PathVariable int id){
        _serviceRepository.deleteById(id);
    }
}
