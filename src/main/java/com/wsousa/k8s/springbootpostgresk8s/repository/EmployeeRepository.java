package com.wsousa.k8s.springbootpostgresk8s.repository;

import com.wsousa.k8s.springbootpostgresk8s.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
