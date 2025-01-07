package com.coding.employee_allocation.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="employee_project_mapping")
public class EmployeeProjectMapping {
	
	@Id
	private String employee_project_id;
	private String projectName;
	private String empId;
	private String projectId;
	private double Allocation;

}
