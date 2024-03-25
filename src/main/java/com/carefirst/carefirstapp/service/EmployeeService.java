package com.carefirst.carefirstapp.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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
		repo.deleteById(employeeId);	
	}
	public void updateEmployee(Employee employee) {
		repo.save(employee);
	}
	public Employee findEmployeeById(long employeeId) {
		 return repo.findById(employeeId).orElseThrow(IllegalArgumentException::new);
	}
	
	public Employee findEmployeeIterator(Long employeeId) {	
		Iterator<Employee> itr =repo.findAll().iterator();
		Employee employee=null;
		while (itr.hasNext()) {
			if(itr.next().getEmployeeId()==employeeId)
			{
				employee =itr.next();
				System.out.println(employee.toString());
			}
				
		}
		return employee;
		 
	}
	
    public List<List<Employee>> getAllEmployees() {
        return List.of(repo.findAll());
    }
}
