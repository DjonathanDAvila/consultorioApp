package com.crud.consultorio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "t_scheduling")
public class Scheduling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scheduling_id")
    private Integer id;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    private LocalDateTime date;
}
