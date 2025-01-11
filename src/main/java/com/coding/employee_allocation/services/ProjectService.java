package com.coding.employee_allocation.services;

import java.util.function.Function;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.ReactiveFluentQuery;
import org.springframework.stereotype.Service;

import com.coding.employee_allocation.dtos.ProjectDto;
import com.coding.employee_allocation.models.Project;
import com.coding.employee_allocation.repositories.ProjectRepository;
import com.coding.employee_allocation.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProjectService implements ProjectRepository {
	
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

	@Override
	public <S extends Project> Mono<S> insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Project> Flux<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Project> Flux<S> insert(Publisher<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Project> Flux<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Project> Flux<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Project> Mono<S> save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Project> Flux<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Project> Flux<S> saveAll(Publisher<S> entityStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Project> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Project> findById(Publisher<String> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> existsById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> existsById(Publisher<String> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Project> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Project> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Project> findAllById(Publisher<String> idStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Long> count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteById(Publisher<String> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> delete(Project entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAllById(Iterable<? extends String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAll(Iterable<? extends Project> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAll(Publisher<? extends Project> entityStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Project> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Project> Mono<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Project> Mono<Long> count(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Project> Mono<Boolean> exists(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Project, R, P extends Publisher<R>> P findBy(Example<S> example,
			Function<ReactiveFluentQuery<S>, P> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
