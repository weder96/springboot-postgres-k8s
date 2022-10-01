package com.wsousa.k8s.springbootpostgresk8s.controller;

import com.wsousa.k8s.springbootpostgresk8s.entity.Employee;
import com.wsousa.k8s.springbootpostgresk8s.exceptions.ResourceNotFoundException;
import com.wsousa.k8s.springbootpostgresk8s.repository.EmployeeRepository;
import com.wsousa.k8s.springbootpostgresk8s.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll(){
        return  ResponseEntity.ok(employeeService.findAll());
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmplooyeeId(@PathVariable(value = "id") Integer id){
               return ResponseEntity.ok().body(employeeService.findById(id));

    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
                                                   @RequestBody Employee employeeDetails) {
        return ResponseEntity.ok(employeeService.updatedEmployee(employeeId, employeeDetails));

    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Integer id){
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
