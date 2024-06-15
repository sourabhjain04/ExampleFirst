package com.RestWithTest.springboot.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import com.RestWithTest.springboot.model.Employee;
import com.RestWithTest.springboot.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private	EmployeeService employeeService;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception{
		//given
		Employee employee = Employee.builder()
				.id(1L)
				.firstName("Vedika")
				.lastName("Jain")
				.email("vedika@gmail.com")
				.build();
		
		BDDMockito.given(employeeService.saveEmployee(any(Employee.class)))
		.willAnswer((invocation)->invocation.getArgument(0));
		//when
		ResultActions response = mockMvc.perform(post("/api/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee)));
		
		
		//then
		
		response.andDo(print()).andExpect(status().isCreated())
				.andExpect(jsonPath("$.firstName",
							is(employee.getFirstName())))
				.andExpect(jsonPath("$.lastName",
						is(employee.getLastName())))
				.andExpect(jsonPath("$.email",
						is(employee.getEmail())));
		
		
		
	}
	
	// get all employees
	
	@Test
	public void givenListOfEmployee_whengetAllEmployee_thenReturnEmployeeList() throws Exception{
		//given
		List<Employee> listOfEmployees = new ArrayList<>();
		
		listOfEmployees.add(Employee.builder().firstName("Vedika")
						.lastName("Jain").email("vedika@gamil.com").build());
		listOfEmployees.add(Employee.builder().firstName("AIsiri")
				.lastName("Shrinath").email("aisiri@gamil.com").build());
		
		BDDMockito.given(employeeService.getAllEmployees()).willReturn(listOfEmployees);
		//when
		ResultActions response = mockMvc.perform(get("/api/employees"));
				
		
		
		//then
		
		response.andExpect(status().isOk())
							.andDo(print())
							.andExpect(jsonPath("$.size()",is(listOfEmployees.size())));
			
		
		
	}
	
	@Test
	public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject() throws Exception{
		//given
		long employeeId = 1L;
		Employee employee = Employee.builder()
				.firstName("AIsiri")
				.lastName("Srinath")
				.email("AIsiri@gmail.com")
				.build();
		
		
	BDDMockito.given(employeeService.getEmployeeById(employeeId))
						.willReturn(Optional.of(employee));
		//when
		ResultActions response = mockMvc.perform(get("/api/employees/{id}", employeeId));
				
		
		
		//then
		
		response.andExpect(status().isOk())
							.andDo(print())
							.andExpect(jsonPath("$.firstName",is(employee.getFirstName())))
							.andExpect(jsonPath("$.lastName",is(employee.getLastName())))
							.andExpect(jsonPath("$.email",is(employee.getEmail())));
			
		
		
	}
	

	@Test
	public void givenInvalidEmployeeId_whenGetEmployeeById_thenReturnEmpty() throws Exception{
		//given
		long employeeId = 1L;
		Employee employee = Employee.builder()
				.firstName("AIsiri")
				.lastName("Srinath")
				.email("AIsiri@gmail.com")
				.build();
		
		
	BDDMockito.given(employeeService.getEmployeeById(employeeId))
						.willReturn(Optional.empty());
		//when
		ResultActions response = mockMvc.perform(get("/api/employees/{id}", employeeId));
				
		
		
		//then
		
		response.andExpect(status().isNotFound())
							.andDo(print());
			
		
		
	}
	

	@Test
	public void givenUpdateEmployee_whenUpdateEmployeeById_thenReturnUpdateEmployeeObject() throws Exception{
		//given
		long employeeId = 1L;
		Employee savedEmployee = Employee.builder()
				.firstName("AIsiri")
				.lastName("Srinath")
				.email("AIsiri@gmail.com")
				.build();
		
		 Employee updatedEmployee = Employee.builder()
					
					.firstName("Vedika")
					.lastName("Jain")
					.email("vedika@gmail.com")
					.build();
		
		
	BDDMockito.given(employeeService.getEmployeeById(employeeId))
						.willReturn(Optional.of(savedEmployee));
	BDDMockito.given(employeeService.updateEmployee(any(Employee.class)))
						.willAnswer((invocation)->invocation.getArgument(0));
		//when
		ResultActions response = mockMvc.perform(put("/api/employees/{id}", employeeId)
				
				.contentType(MediaType.APPLICATION_JSON)
				
				.content(objectMapper.writeValueAsString(updatedEmployee)));
				
		
		
		//then
		
			
		response.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.firstName",is(updatedEmployee.getFirstName())))
		.andExpect(jsonPath("$.lastName",is(updatedEmployee.getLastName())))
		.andExpect(jsonPath("$.email",is(updatedEmployee.getEmail())));

		
	}
	
	

	@Test
	public void givenUpdateEmployee_whenUpdateEmployee_thenReturn404() throws Exception{
		//given
		long employeeId = 1L;
		Employee savedEmployee = Employee.builder()
				.firstName("AIsiri")
				.lastName("Srinath")
				.email("AIsiri@gmail.com")
				.build();
		
		 Employee updatedEmployee = Employee.builder()
					
					.firstName("Vedika")
					.lastName("Jain")
					.email("vedika@gmail.com")
					.build();
		
		
	BDDMockito.given(employeeService.getEmployeeById(employeeId))
						.willReturn(Optional.empty());
	BDDMockito.given(employeeService.updateEmployee(any(Employee.class)))
						.willAnswer((invocation)->invocation.getArgument(0));
		//when
		ResultActions response = mockMvc.perform(put("/api/employees/{id}", employeeId)
				
				.contentType(MediaType.APPLICATION_JSON)
				
				.content(objectMapper.writeValueAsString(updatedEmployee)));
				
		
		
		//then
		
			
		response.andExpect(status().isNotFound())
		.andDo(print());

		
	}
	
	
	
	@Test
	public void givenEmployeeId_whenDeleteEmoplyee_thenNothing() throws Exception {
		//given
		long employeeId = 1L;
		
		willDoNothing().given(employeeService).deleteEmployee(employeeId);
		//when
		ResultActions response = mockMvc.perform(delete("/api/employees/{id}", employeeId));
		//then
		
		response.andExpect(status().isOk())
		.andDo(print());

	}
	
	

}
