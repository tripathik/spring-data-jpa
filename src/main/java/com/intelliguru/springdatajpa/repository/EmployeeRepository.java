package com.intelliguru.springdatajpa.repository;

import com.intelliguru.springdatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmployeeName(String userName);
}
