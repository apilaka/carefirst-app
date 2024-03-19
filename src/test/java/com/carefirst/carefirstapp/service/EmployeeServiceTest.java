package com.carefirst.carefirstapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.carefirst.carefirstapp.dto.EmployeeDTO;
import com.carefirst.carefirstapp.dto.EmployeeMapper;
import com.carefirst.carefirstapp.entity.Employee;
import com.carefirst.carefirstapp.repository.EmployeeRepository;



/**
 * 
 */
class EmployeeServiceTest {

@InjectMocks
private EmployeeRepository employeeRepository;

@InjectMocks
private EmployeeMapper mapper;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(employeeRepository);
		Date date =new Date();
		long employeeId =1111;
		String firstName ="Ananta";
		String lastName= "Pilaka";
		String emailAddress= "apilaka@yahoo.ca";	
		String phone="8042670940";
		Date birthDate =date;
		String jobTitle="Manager";
		String department ="IT";	
		String location="Washington DC";
		Date startDate=date;
		String reportingManager= "Manager";
		

		Employee employee= new Employee(employeeId, firstName, lastName, emailAddress, phone, birthDate,jobTitle,department, location, startDate, reportingManager);

		Date date1 =new Date();
		long employeeId1 =1111;
		String firstName1 ="Ananta";
		String lastName1= "Pilaka";
		String emailAddress1= "apilaka@yahoo.ca";	
		String phone1="8042670940";
		Date birthDate1 =date;
		String jobTitle1="Manager";
		String department1 ="IT";	
		String location1="Washington DC";
		Date startDate1=date;
		String reportingManager1= "Manager";
		EmployeeDTO dto= new EmployeeDTO(employeeId1, firstName1, lastName1, emailAddress1, phone1, birthDate1,jobTitle1,
				department1, location1, startDate1, reportingManager1);
		
		Mockito.when(mapper.toEmployee(dto)).thenReturn(employee);
	}
	@Test
	public void shouldSuccessfullyListEmployees()
	{
		
	}
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEmployeeService() {
		fail("Not yet implemented");
	}
	@Test
	void testListEmployees() {
		fail("Not yet implemented");
	}
	@Test
	void testAddEmployee() {
		fail("Not yet implemented");
	}

}
