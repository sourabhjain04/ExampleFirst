package com.RestWithTest.springboot.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.RestWithTest.springboot.model.Employee;


@DataJpaTest
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository employeeRepository; 
	
	//Junit test for save employee operation
	@DisplayName("Junit test for save Employee Operation")
	@Test
	public void givenEmployeeObject_WhenSave_thenReturnSavedEmploye() {
		
		// given - precondition or setup
		
		Employee employee = Employee.builder()
							.firstName("Vedika")
							.lastName("Jain")
							.email("vedika@gmail.com")
							.build();
		
		// When
		Employee savedEmployee = employeeRepository.save(employee);
		
		//then- Verify the output
		assertThat(savedEmployee).isNotNull(); 
		  assertThat(savedEmployee.getId()).isGreaterThan(0); 
	}
	
	// junit  for get all employees operations
	@DisplayName("Junit for get all emloyees operation")
	@Test
	public void givenEmployeeList_WhenFindAll_thenEmployeeList() {
		//given
		Employee employee = Employee.builder()
				.firstName("Vedika")
				.lastName("Jain")
				.email("vedika@gmail.com")
				.build();
		
		Employee employee1 = Employee.builder()
				.firstName("Aisiri")
				.lastName("srinath")
				.email("Aisiri@gmail.com")
				.build();
		
		employeeRepository.save(employee);
		employeeRepository.save(employee1);
		//When
		
		List<Employee> employeeList = employeeRepository.findAll();
		//then
		
		assertThat(employeeList).isNotNull(); 
		  assertThat(employeeList.size()).isEqualTo(2);
		
	}
	
	@DisplayName("Junit test for get Employee by id Operation")
	@Test
	public void givenEmployeeObject_WhenFindById_thenReturnEmployeeObject() {
		
		// given - precondition or setup
		
		Employee employee = Employee.builder()
							.firstName("Vedika")
							.lastName("Jain")
							.email("vedika@gmail.com")
							.build();
		employeeRepository.save(employee);
		// When
		Employee employeeDB = employeeRepository.findById(employee.getId()).get();
		
		//then- Verify the output
		assertThat(employeeDB).isNotNull(); 
		  
	}
	
	@DisplayName("Junit test for get Employee by email Operation")
	@Test
	public void givenEmployeeEmail_WhenFindByEmail_thenReturnEmployeeObject() {
		
		// given - precondition or setup
		
		Employee employee = Employee.builder()
							.firstName("Vedika")
							.lastName("Jain")
							.email("vedika@gmail.com")
							.build();
		employeeRepository.save(employee);
		// When
		Employee employeeDB = employeeRepository.findByEmail(employee.getEmail()).get();
		
		//then- Verify the output
		assertThat(employeeDB).isNotNull(); 
		  
	}
	

	@DisplayName("Junit test for update Employee Operation")
	@Test
	public void givenEmployeeObject_WhenUpdateEmployee_thenReturnUpdatedEmployee() {
		
		// given - precondition or setup
		
		Employee employee = Employee.builder()
							.firstName("Vedika")
							.lastName("Jain")
							.email("vedika@gmail.com")
							.build();
		employeeRepository.save(employee);
		// When
		Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
		savedEmployee.setEmail("ram@gmail.com");
		savedEmployee.setFirstName("Ram");
		Employee updatedEmployee = employeeRepository.save(savedEmployee);
		
		//then- Verify the output
		assertThat(updatedEmployee.getEmail()).isEqualTo("ram@gmail.com");
		assertThat(updatedEmployee.getFirstName()).isEqualTo("Ram");
		
		  
	}
	
	@DisplayName("Junit test for custom Query Operation")
	@Test
	public void givenEmployeeFisrtNameAndLastName_WhenFindByJPQL_thenReturnEmployeeObject() {
		
		// given - precondition or setup
		
		Employee employee = Employee.builder()
							.firstName("Vedika")
							.lastName("Jain")
							.email("vedika@gmail.com")
							.build();
		employeeRepository.save(employee);
		String firstName="Vedika";
		String lastName="Jain";
		// When
		Employee savedEmployee = employeeRepository.findByJPQL(firstName, lastName);
		
		//then- Verify the output
		assertThat(savedEmployee).isNotNull(); 
		  
	}
	
	
	
	
}
