package com.coding.employee_allocation.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.coding.employee_allocation.models.Employee;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String> {

}
