package com.coding.employee_allocation.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.stereotype.Service;

import com.coding.employee_allocation.dtos.EmployeeDto;
import com.coding.employee_allocation.dtos.EmployeeProjectDto;
import com.coding.employee_allocation.models.Employee;
import com.coding.employee_allocation.models.Project;
import com.coding.employee_allocation.repositories.EmployeeRepository;
import com.coding.employee_allocation.repositories.ProjectRepository;
import com.coding.employee_allocation.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<EmployeeProjectDto> getEmployeeWithProjectDetails()
	{
	   LookupOperation lookupOperation=LookupOperation.newLookup().from("project").localField("projectId").foreignField("_id").as("employeeProjects");
	   
	   Aggregation aggregation=Aggregation.newAggregation(lookupOperation);
	   AggregationResults<EmployeeProjectDto> aggregationResult=mongoTemplate.aggregate(aggregation,"employee", EmployeeProjectDto.class);
	   return aggregationResult.getMappedResults();
	}
	
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
				doOnNext(d->d.setId(id))).flatMap(employeeRepository::save).map(AppUtils::EmployeeEntityToDto);
	}
	
	
	public Mono<Employee> findSecondExperiencedPerson()
	{
		Mono<Employee> getEmployees=employeeRepository.findSecondHighExperienceEmployee();
        return getEmployees;
		
	}
	
	public Flux<EmployeeDto> findEmployessWithPrimaryAndSecondarySkills()
	{
		Flux<Employee> getEmployees=employeeRepository.findAll();
		Flux<EmployeeDto> result=getEmployees.filter(e-> (e.getPrimarySkill()!=null )
				&& (e.getSecondarySkill()!=null)).map(AppUtils::EmployeeEntityToDto);
		return result;
	}
	
	public Flux<EmployeeDto> findEmployesNonPrimarySkills()
	{
		Flux<Employee> getEmployees=employeeRepository.findAll();
		Flux<EmployeeDto> result=getEmployees.filter(e-> (e.getPrimarySkill()==null && e.getProjectId() !=null)).map(AppUtils::EmployeeEntityToDto);
		return result;
	} 
	
	

}
