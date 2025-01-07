package com.coding.employee_allocation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.employee_allocation.dtos.ProjectDto;
import com.coding.employee_allocation.repositories.ProjectRepository;
import com.coding.employee_allocation.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Mono<ProjectDto> saveProject(Mono<ProjectDto> projectDto)
	{
		return projectDto.map(AppUtils::ProjectDtoToEntity).flatMap(projectRepository::insert).map(AppUtils::ProjectEntityToDto);
	}
	
	public Flux<ProjectDto> getProjects()
	{
		return projectRepository.findAll().map(AppUtils::ProjectEntityToDto);
	}
	
	public Mono<ProjectDto> updateProject(Mono<ProjectDto> projectDto, String id)
	{
		

		return projectRepository.findById(id).flatMap(e-> projectDto.map(AppUtils::ProjectDtoToEntity).
				doOnNext(d->d.setId(id))).flatMap(projectRepository::save).map(AppUtils::ProjectEntityToDto);
	}

}
