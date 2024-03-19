package com.carefirst.carefirstapp.dto;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.carefirst.carefirstapp.entity.Employee;



@Service
public class EmployeeMapper {

	public Employee toEmployee(EmployeeDTO dto) {
		if(null==dto)
		{
			throw new NullPointerException("employee DTO is null");
			
		}
		Employee employee = new Employee();
		employee.setEmployeeId(dto.getEmployeeId());
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmailAddress(dto.getEmailAddress());
		employee.setPhone(dto.getPhone());
		employee.setBirthDate(dto.getBirthDate());
		employee.setJobTitle(dto.getJobTitle());
		employee.setDepartment(dto.getDepartment());
		employee.setLocation(dto.getLocation());
		employee.setStartDate(dto.getStartDate());
		employee.setManagerReporting(dto.getManagerReporting());
		
		

		return employee;

	}

	public EmployeeDTO toEmployeeDTO(Employee employee)

	{
		long employeeId = employee.getEmployeeId();
		String firstName=employee.getFirstName();
		String lastName=employee.getLastName();
		String emailAddress=employee.getEmailAddress();
		String phone =employee.getPhone();
		Date birthDate =employee.getBirthDate();
		String jobTitle =employee.getJobTitle();
		String department= employee.getDepartment();
		String location=employee.getLocation();
		Date startDate =employee.getStartDate();
		String managerReporting =employee.getManagerReporting();
		

		return new EmployeeDTO(employeeId, firstName, lastName, emailAddress, phone,birthDate, jobTitle, department, location, startDate, managerReporting);

	}
}
