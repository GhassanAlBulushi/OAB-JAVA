package com.training.Employee.Controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.Employee.Service.EmployeeService;
import com.training.Employee.model.Employee;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(service.save(employee));
    }

    @GetMapping
    public ResponseEntity<Employee> getEmployee(@RequestParam String empName) {
        Optional<Employee> employee = service.findByName(empName);
        return employee.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(service.update(employee));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEmployee(@RequestParam String empName) {
        service.deleteByName(empName);
        return ResponseEntity.noContent().build();
    }
}
