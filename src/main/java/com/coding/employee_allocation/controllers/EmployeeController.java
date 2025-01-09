package com.coding.employee_allocation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.employee_allocation.dtos.EmployeeDto;
import com.coding.employee_allocation.dtos.EmployeeProjectDto;
import com.coding.employee_allocation.models.Employee;
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
	

	@GetMapping("getEmployeesWithProject")
	public List<EmployeeProjectDto> getEmployeesWithProject()
	{
		return employeeService.getEmployeeWithProjectDetails();
	}
	
	@PutMapping("updateEmployee/{id}")
	public Mono<EmployeeDto> updateEmployee(@RequestBody Mono<EmployeeDto> employeeDto,@PathVariable String id)
	{
		return employeeService.updateEmployee(employeeDto,id);
	}
	
	@GetMapping("getSecondEmployee")
	public Mono<Employee> getSecondEmployee()
	{
		return employeeService.findSecondExperiencedPerson();
	}
	
	@GetMapping("getEmployeesWithPrimaryAndSecondarySkills")
	public Flux<EmployeeDto> getEmployeesWithPrimaryAndSecondarySkills()
	{
		return employeeService.findEmployessWithPrimaryAndSecondarySkills();
	}
	
	@GetMapping("getEmployessWithNonPrimarySkills")
	public Flux<EmployeeDto> getEmployessWithNonPrimarySkills()
	{
		return employeeService.findEmployesNonPrimarySkills();
	}
	
	
	

}
