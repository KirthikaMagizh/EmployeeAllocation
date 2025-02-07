package com.coding.employee_allocation.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="employeeObj")
public class Employee {
	@Id
	private String id;
	private String employeeName;
	private CapabilityCentre  capabilityCentre;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateOfJoining;
	private Designation  designation;
	private String primarySkill;
	private String secondarySkill;
	private int overAllExperience;
	private String mailId;
	private List<ObjectId> projectId;
	
	

}

