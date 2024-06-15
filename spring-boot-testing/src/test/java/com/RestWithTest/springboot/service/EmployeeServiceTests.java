package com.RestWithTest.springboot.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.mockito.BDDMockito.willDoNothing;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.RestWithTest.springboot.exception.ResourceNotFoundException;
import com.RestWithTest.springboot.model.Employee;
import com.RestWithTest.springboot.repository.EmployeeRepository;
import com.RestWithTest.springboot.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

	@Mock
	private EmployeeRepository employeeRepository;
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	private Employee employee;
	@BeforeEach
	public void setup() {
		 employee = Employee.builder()
				.id(1L)
				.firstName("Vedika")
				.lastName("Jain")
				.email("vedika@gmail.com")
				.build();
	}	
	
	@DisplayName("JUnit Test for saveEmployee method")
	@Test
	public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject() {
		//given - precondition or setup
		
		
		//here we are mocking the method of employee repository class i.e findByEmail and Save
		given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.empty());
		given(employeeRepository.save(employee)).willReturn(employee);
		System.out.println(employeeRepository);
		System.out.println(employeeService);
		
		// when- action
		Employee savedEmployee = employeeService.saveEmployee(employee);
		
		System.out.println(savedEmployee);
		
		// then -verify the output
		
		Assertions.assertThat(savedEmployee).isNotNull();
		
	}
	@DisplayName("JUnit Test for saveEmployee method which throws exception")
	@Test	
	public void givenExistingEmail_whenSaveEmployee_thenThrowsException() {
		// given
		given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.of(employee));
		//given(employeeRepository.save(employee)).willReturn(employee);
		System.out.println(employeeRepository);
		System.out.println(employeeService);
		// to make the test case fail
		//Employee savedEmployee = employeeService.saveEmployee(employee);
	//	System.out.println(savedEmployee);
		
		org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class,()->{employeeService.saveEmployee(employee);
		}
		);
		
		verify(employeeRepository, never()).save(any(Employee.class));
	
	}
	
	// Junit test for getallEmployees method
	@DisplayName("Juint Test for GetAll Employees method(NS)")
	@Test
	public void givenEmptyEmployeesList_whenGetAllEmployees_thenReturnEmptyEmployeesList() {
		//given
		Employee employee1 = Employee.builder()
				.id(1L)
				.firstName("AIsiri")
				.lastName("Srinath")
				.email("AIsiri@gmail.com")
				.build();
		given(employeeRepository.findAll()).willReturn(Collections.emptyList());
		//when
		List<Employee> employeeList = employeeService.getAllEmployees();
		//then
		assertThat(employeeList).isEmpty();
		assertThat(employeeList.size()).isEqualTo(0);
		
		
	}
	// Junit test for getallEmployees method
	@DisplayName("Juint Test for GetAll Employees method(PS)")
	@Test
	public void givenEmployeesList_whenGetAllEmployees_thenReturnEmployeesList() {
		//given
		Employee employee1 = Employee.builder()
				.id(1L)
				.firstName("AIsiri")
				.lastName("Srinath")
				.email("AIsiri@gmail.com")
				.build();
		given(employeeRepository.findAll()).willReturn(List.of(employee, employee1));
		//when
		List<Employee> employeeList = employeeService.getAllEmployees();
		//then
		assertThat(employeeList).isNotNull();
		assertThat(employeeList.size()).isEqualTo(2);
		
		
	}
	@DisplayName("Juint Test for Get Employees by ID (PS)")
	@Test
	public void givenEmployeeId_whenGetEmployeebyId_thenReturnEmployeeObject() {
		//given
		given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));
		
		//when
		Employee savedEmployee = employeeService.getEmployeeById(employee.getId()).get();
		//then
		assertThat(savedEmployee).isNotNull();
	
	}
	@DisplayName("junit test for update Employee method")
	@Test
	public void givenEmployeeObject_whenUpdateEmoplyee_thenReturnUpdatedEmployee() {
		//given
		given(employeeRepository.save(employee)).willReturn(employee);
		employee.setEmail("sourabh@gmail.com");
		employee.setFirstName("Sourabh");
		
		//when
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		//then
		assertThat(updatedEmployee.getEmail()).isEqualTo("sourabh@gmail.com");
		assertThat(updatedEmployee.getFirstName()).isEqualTo("Sourabh");
	}
	
	@DisplayName("junit test for Delete Employee method")
	@Test
	public void givenEmployeeId_whenDeleteEmoplyee_thenNothing() {
		//given
		long employeeId = 1L;
		
		willDoNothing().given(employeeRepository).deleteById(employeeId);
		//when
		employeeService.deleteEmployee(employeeId);
		//then
		verify(employeeRepository, times(1)).deleteById(employeeId);
		
	}
	
}
