package com.coding.employee_allocation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.employee_allocation.dtos.EmployeeDto;
import com.coding.employee_allocation.repositories.EmployeeRepository;
import com.coding.employee_allocation.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Mono<EmployeeDto> saveEmployee(Mono<EmployeeDto> employeeDto)
	{
		return employeeDto.map(AppUtils::EmployeeDtoToEntity).flatMap(employeeRepository::insert).map(AppUtils::EmployeeEntityToDto);
	}
	
	public Flux<EmployeeDto> getEmployees()
	{
		return employeeRepository.findAll().map(AppUtils::EmployeeEntityToDto);
	}
	
	public Mono<EmployeeDto> updateEmployee(Mono<EmployeeDto> employeeDto, String id)
	{
		
		

		return employeeRepository.findById(id).flatMap(e-> employeeDto.map(AppUtils::EmployeeDtoToEntity).
				doOnNext(d->d.setEmployeeId(id))).flatMap(employeeRepository::save).map(AppUtils::EmployeeEntityToDto);
	}
	
	
	

}
