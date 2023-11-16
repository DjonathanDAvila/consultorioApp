package com.crud.consultorio.repositories;

import com.crud.consultorio.model.Service;
import com.crud.consultorio.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service, Integer>  {
}
