package com.crud.consultorio.repositories;

import com.crud.consultorio.model.Scheduling;
import com.crud.consultorio.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISchedulingRepository extends JpaRepository<Scheduling, Integer> {
}
