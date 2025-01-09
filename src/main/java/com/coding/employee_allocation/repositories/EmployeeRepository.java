package com.coding.employee_allocation.repositories;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.coding.employee_allocation.models.Employee;

import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String> {
	@Aggregation(pipeline = {
			  
			  "{ '$sort' : { 'overAllExperience' : -1 } }",
			  "{ '$skip' : ?1 }",
			  "{ '$limit' : ?1 }"
			})
 Mono<Employee> findSecondHighExperienceEmployee();
	

}
