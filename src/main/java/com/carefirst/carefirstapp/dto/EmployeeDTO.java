package com.carefirst.carefirstapp.dto;

import java.util.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
	
	private long employeeId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phone;
	private Date birthDate;
	private String jobTitle;
	private String department;
	private String location;
	private Date startDate;
	private String managerReporting;


}
