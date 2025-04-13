package com.training.Employee.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.Employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByName(String name);
    void deleteByName(String name);
}