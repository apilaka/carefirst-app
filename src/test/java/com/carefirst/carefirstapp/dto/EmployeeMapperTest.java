package com.carefirst.carefirstapp.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.carefirst.carefirstapp.entity.Employee;



class EmployeeMapperTest {
	
	 EmployeeMapper mapper;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Not yet setUpBeforeClass");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Not yet tearDownAfterClass");
	}

	@BeforeEach
	void setUp() throws Exception {
		 mapper=new EmployeeMapper();
		System.out.println("Not yet @BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Not yet @AfterEach");
	}

	@Test
	void shouldMapEmployeeDtoToEmployee() {
		
		Date date =new Date();
		EmployeeDTO dto =	 new EmployeeDTO(1111, "Ananta", "Pilaka", "apilaka@yahoo.ca", "80042670940",date, "Manager","IT", "Washington DC", date, "Manager");
	
		Employee employee = mapper.toEmployee(dto);
		
		Assertions.assertEquals(dto.getEmployeeId(), employee.getEmployeeId());
		Assertions.assertEquals(dto.getFirstName(), employee.getFirstName());
		Assertions.assertEquals(dto.getLastName(), employee.getLastName());
		Assertions.assertEquals(dto.getEmailAddress(), employee.getEmailAddress());
		Assertions.assertEquals(dto.getPhone(), employee.getPhone());
		Assertions.assertEquals(dto.getBirthDate(), employee.getBirthDate());
		Assertions.assertEquals(dto.getJobTitle(), employee.getEmployeeId());
		Assertions.assertEquals(dto.getDepartment(), employee.getDepartment());
		Assertions.assertEquals(dto.getLocation(), employee.getEmployeeId());	
		Assertions.assertEquals(dto.getStartDate(), employee.getStartDate());
		Assertions.assertEquals(dto.getManagerReporting(), employee.getManagerReporting());
		
		
		
		
		

	}	
	
	@Test
	void shouldMapEmployeeToEmployeeDto() {

		Date date =new Date();
		Employee employee =	 new Employee(1111, "Ananta", "Pilaka", "apilaka@yahoo.ca", "80042670940",date, "Manager","IT", "Washington DC", date, "Manager");
		EmployeeDTO employeeDTO = mapper.toEmployeeDTO(employee);
	
		
		
		Assertions.assertEquals(employee.getEmployeeId(), employeeDTO.getEmployeeId());
		//Add other assertions
		
		Assertions.assertEquals(employee.getEmployeeId(), employeeDTO.getEmployeeId());
		Assertions.assertEquals(employee.getFirstName(), employeeDTO.getFirstName());
		Assertions.assertEquals(employee.getLastName(), employeeDTO.getLastName());
		Assertions.assertEquals(employee.getEmailAddress(), employeeDTO.getEmailAddress());
		Assertions.assertEquals(employee.getPhone(), employeeDTO.getPhone());
		Assertions.assertEquals(employee.getBirthDate(), employeeDTO.getBirthDate());
		Assertions.assertEquals(employee.getJobTitle(), employeeDTO.getEmployeeId());
		Assertions.assertEquals(employee.getDepartment(), employeeDTO.getDepartment());
		Assertions.assertEquals(employee.getLocation(), employeeDTO.getEmployeeId());	
		Assertions.assertEquals(employee.getStartDate(), employeeDTO.getStartDate());
		Assertions.assertEquals(employee.getManagerReporting(), employeeDTO.getManagerReporting());
		
		
		
	}
	
	@Test
	void shouldThrowExceptionIfEmployeeDtoIsNull(EmployeeDTO dto){
		
		var msg = Assertions.assertThrows(NullPointerException.class,()->mapper.toEmployee(null));
		assertEquals(msg, "employee DTO is null",msg.getMessage());
	
			

		
	}
		


}
