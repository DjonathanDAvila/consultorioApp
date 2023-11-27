
package com.crud.consultorio.DTOs;

import com.crud.consultorio.model.Test;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestDTO {
    

    private String name;
    private String description;
    private double price;
    private int duration;
    
}
