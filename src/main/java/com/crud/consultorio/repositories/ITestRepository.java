
package com.crud.consultorio.repositories;

import com.crud.consultorio.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestRepository extends JpaRepository<Test, Integer> {
    
}
