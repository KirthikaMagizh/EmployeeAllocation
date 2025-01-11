package com.coding.employee_allocation.dtos;

import java.time.LocalDate;

import com.coding.employee_allocation.models.CapabilityCentre;
import com.coding.employee_allocation.models.Designation;
import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	
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
