package com.coding.employee_allocation.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.coding.employee_allocation.models.AccountName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
	private String id;
	private AccountName accountName;
	private String projectName;
	private double allocation;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate projectStartDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate projectEndDate;
	private String remarks;
//	private String projectId;
}
