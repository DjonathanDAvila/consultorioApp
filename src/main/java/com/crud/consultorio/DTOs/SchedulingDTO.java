package com.crud.consultorio.DTOs;

import com.crud.consultorio.model.Patient;
import com.crud.consultorio.model.Status;
import com.crud.consultorio.model.Test;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class SchedulingDTO {
    private Integer patientID;
    private Integer testID;
    private Integer statusID;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
}
