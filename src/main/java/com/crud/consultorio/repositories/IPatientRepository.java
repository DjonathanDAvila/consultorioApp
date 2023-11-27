
package com.crud.consultorio.repositories;

import com.crud.consultorio.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {
}
