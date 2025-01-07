package com.coding.employee_allocation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.employee_allocation.dtos.EmployeeDto;
import com.coding.employee_allocation.services.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {
	
	@Autowired 
	private EmployeeService employeeService;
	
	@PostMapping("addEmployee")
	public Mono<EmployeeDto> SaveEmployee(@RequestBody Mono<EmployeeDto> employeeDto)
	{
		return employeeService.saveEmployee(employeeDto);
	}
	
	@GetMapping("getEmployees")
	public Flux<EmployeeDto> getEmployees()
	{
		return employeeService.getEmployees();
	}
	
	@PutMapping("updateEmployee/{id}")
	public Mono<EmployeeDto> UpdateEmployee(@RequestBody Mono<EmployeeDto> employeeDto,@PathVariable String id)
	{
		return employeeService.updateEmployee(employeeDto,id);
	}
	
	
	
	

}
