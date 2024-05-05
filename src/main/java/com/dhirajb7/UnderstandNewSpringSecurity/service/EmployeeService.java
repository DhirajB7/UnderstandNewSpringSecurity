package com.dhirajb7.UnderstandNewSpringSecurity.service;

import java.util.List;

import com.dhirajb7.UnderstandNewSpringSecurity.modal.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int theId);

	Employee save(Employee theEmployee);

	void deleteById(int theId);

}
