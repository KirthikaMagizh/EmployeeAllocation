package com.coding.employee_allocation.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="project")
public class Project {
	@Id
	private String id;
	private AccountName accountName;
	private String projectName;
	private double allocation;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate projectStartDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate projectEndDate;
	private String remarks;

}
