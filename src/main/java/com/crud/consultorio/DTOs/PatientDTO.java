
package com.crud.consultorio.DTOs;

import java.time.LocalDate;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class PatientDTO {
    
    private String name;
    private String sex;
    private long CPF;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate bornDate;
    
}
