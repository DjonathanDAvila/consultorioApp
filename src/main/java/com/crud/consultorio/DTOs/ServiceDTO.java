package com.crud.consultorio.DTOs;

import com.crud.consultorio.model.PaymentType;
import com.crud.consultorio.model.Scheduling;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDTO {
    private double price;
    private Integer paymentTypeID;
    private Integer schedulingID;
    private String obs;
}
