package com.coding.employee_allocation.utils;

import org.springframework.beans.BeanUtils;

import com.coding.employee_allocation.dtos.EmployeeDto;
import com.coding.employee_allocation.dtos.ProjectDto;
import com.coding.employee_allocation.models.Employee;
import com.coding.employee_allocation.models.Project;

public class AppUtils {
	
	public static EmployeeDto EmployeeEntityToDto(Employee employee)
	{
		EmployeeDto employeeDto=new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}
	
	public static Employee EmployeeDtoToEntity(EmployeeDto employeeDto)
	{
		Employee employee=new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		return employee;
	}
	
	public static ProjectDto ProjectEntityToDto(Project project)
	{
		ProjectDto projectDto=new ProjectDto();
		BeanUtils.copyProperties(project, projectDto);
		return projectDto;
	}
	
	public static Project ProjectDtoToEntity(ProjectDto projectDto)
	{
		Project project=new Project();
		BeanUtils.copyProperties(projectDto, project);
		return project;
	}
	
	

}
