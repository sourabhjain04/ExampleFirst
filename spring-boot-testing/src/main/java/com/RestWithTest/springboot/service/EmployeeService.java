package com.RestWithTest.springboot.service;

import java.util.List;
import java.util.Optional;


import com.RestWithTest.springboot.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Optional<Employee>getEmployeeById(long id);
	
	Employee updateEmployee(Employee updateEmployee);
	
	void deleteEmployee(long id);
}
