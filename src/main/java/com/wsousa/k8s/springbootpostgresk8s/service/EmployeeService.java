package com.wsousa.k8s.springbootpostgresk8s.service;

import com.wsousa.k8s.springbootpostgresk8s.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> findAll();
    Employee findById(Integer id);

    Employee updatedEmployee(Integer employeeId, Employee employeeDetails);
    void delete(Integer id);
}