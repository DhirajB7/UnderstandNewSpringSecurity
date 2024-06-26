package com.dhirajb7.UnderstandNewSpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhirajb7.UnderstandNewSpringSecurity.modal.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
