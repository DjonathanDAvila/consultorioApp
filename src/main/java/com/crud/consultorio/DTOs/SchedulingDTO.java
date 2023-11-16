package com.crud.consultorio.DTOs;

import com.crud.consultorio.model.Patient;
import com.crud.consultorio.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SchedulingDTO {
    private Patient patient;
    private Test test;
    private Status status;
    private Date date;
}
