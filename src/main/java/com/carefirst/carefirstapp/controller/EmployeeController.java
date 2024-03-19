package com.carefirst.carefirstapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carefirst.carefirstapp.entity.Employee;
import com.carefirst.carefirstapp.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v3")
@EnableAutoConfiguration
@RequiredArgsConstructor
@Api(produces = "application/json", value = "Care First Employee Management Application")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Retrieve all Employees - (“/employees”) 
	
	
    @GetMapping
    @RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrievede all employees"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
	public CompletableFuture<Object> listEmployees() {
		return CompletableFuture.completedFuture(employeeService.listEmployees());
	}

	// Create a new Employee - (“/employees”) 
	@PostMapping
	@ApiOperation(value = "Create a new Employee", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created a new employee"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Application failed to process the request") })
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);

	}

	// Delete an Employee - (“/employees/{id}”) 
	
	
	@RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Retrieve specific donor with the supplied donor id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the Employee with the Employee id"),
            @ApiResponse(code = 401, message = "You are not authorized to access this resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
)
	public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);

	}

	// Update Employee details - (“/employees/{id}”) 
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee updated "),
            @ApiResponse(code = 401, message = "You are not authorized access the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Application failed to process the request")
    }
    )
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return new ResponseEntity<String>("Updated ", HttpStatus.OK);

	}
	
	@RequestMapping(value = "/find/{employeeId}", method = RequestMethod.GET)
	    @ApiOperation(value = "Retrieve specific donor with the supplied donor id", response = ResponseEntity.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved the Employee with the Employee id"),
	            @ApiResponse(code = 401, message = "You are not authorized to access this resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	            @ApiResponse(code = 500, message = "Application failed to process the request")
	    }
	)
	public ResponseEntity<Employee> findEmployeeById(@PathVariable("employeeId") long employeeId) {
		Employee employee = employeeService.findEmployeeById(employeeId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);

	}

}
