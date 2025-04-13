package com.training.Employee.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.training.Employee.Repository.EmployeeRepository;
import com.training.Employee.model.Employee;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public Optional<Employee> findByName(String name) {
        return repository.findByName(name);
    }

    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    public void deleteByName(String name) {
        repository.deleteByName(name);
    }
}