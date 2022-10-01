package com.wsousa.k8s.springbootpostgresk8s.service.impl;

import com.wsousa.k8s.springbootpostgresk8s.entity.Employee;
import com.wsousa.k8s.springbootpostgresk8s.exceptions.ResourceNotFoundException;
import com.wsousa.k8s.springbootpostgresk8s.repository.EmployeeRepository;
import com.wsousa.k8s.springbootpostgresk8s.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee not found"+id));
    }

    @Override
    public Employee updatedEmployee(Integer employeeId, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        employee.setName(employeeDetails.getName());
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        Employee employee= employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee not found"+id));
        employeeRepository.delete(employee);
    }
}
