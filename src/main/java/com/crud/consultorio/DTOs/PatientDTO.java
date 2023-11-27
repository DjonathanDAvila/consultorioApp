
package com.crud.consultorio.DTOs;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDTO {
    
    private String name;
    private String sex;
    private long CPF;
    private Date bornDate;
    
}
