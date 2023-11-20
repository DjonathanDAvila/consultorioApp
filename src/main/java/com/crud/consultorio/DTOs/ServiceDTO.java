package com.crud.consultorio.DTOs;

import com.crud.consultorio.model.Scheduling;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDTO {
    private double price;
    private PaymentType paymentType;
    private Scheduling scheduling;
    private String obs;
}
