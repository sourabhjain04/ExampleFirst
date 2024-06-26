package com.RestWithTest.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RestWithTest.springboot.exception.ResourceNotFoundException;
import com.RestWithTest.springboot.model.Employee;
import com.RestWithTest.springboot.repository.EmployeeRepository;
import com.RestWithTest.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		Optional<Employee> savedEmployee = employeeRepository.findByEmail(employee.getEmail());
		if(savedEmployee.isPresent()) {
			throw new ResourceNotFoundException("Employee already exits with given email: "+ employee.getEmail());
		}
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
	
		return employeeRepository.findById(id);
	}

	@Override
	public Employee updateEmployee(Employee updateEmployee) {
		
		return employeeRepository.save(updateEmployee);
	}

	@Override
	public void deleteEmployee(long id) {
	
		employeeRepository.deleteById(id);
		
	}

}
