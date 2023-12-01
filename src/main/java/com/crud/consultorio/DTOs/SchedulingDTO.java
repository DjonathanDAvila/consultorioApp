package com.crud.consultorio.DTOs;

import com.crud.consultorio.model.Patient;
import com.crud.consultorio.model.Status;
import com.crud.consultorio.model.Test;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SchedulingDTO {
    private Integer patient;
    private Integer test;
    private Integer status;
    private Date date;
}
