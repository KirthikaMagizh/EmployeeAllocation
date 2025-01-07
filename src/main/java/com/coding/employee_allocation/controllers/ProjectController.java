package com.coding.employee_allocation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.employee_allocation.dtos.ProjectDto;
import com.coding.employee_allocation.services.ProjectService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired 
	private ProjectService projectService;
	
	@PostMapping("addProject")
	public Mono<ProjectDto> SaveProject(@RequestBody Mono<ProjectDto> projectDto)
	{
		return projectService.saveProject(projectDto);
	}
	
	@GetMapping("getProjects")
	public Flux<ProjectDto> getProject()
	{
		return projectService.getProjects();
	}
	
	@PutMapping("updateProject/{id}")
	public Mono<ProjectDto> UpdateProject(@RequestBody Mono<ProjectDto> projectDto,@PathVariable String id)
	{
		return projectService.updateProject(projectDto,id);
	}

}
