package com.carefirst.carefirstapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carefirst.carefirstapp.entity.Employee;
import com.carefirst.carefirstapp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	public List<Employee> listEmployees() {
		return repo.findAll();
	}
	public void createEmployee(Employee employee) {
		repo.save(employee);
	}
	public void deleteEmployee(Long employeeId) {	
		Employee employee =repo.findById(employeeId).orElseThrow(IllegalArgumentException::new);
		repo.deleteById(employeeId);	
	}
	public void updateEmployee(Employee employee) {
		repo.save(employee);
	}
	public Employee findEmployeeById(long employeeId) {
		 return repo.findById(employeeId).orElseThrow(IllegalArgumentException::new);
	}
}
