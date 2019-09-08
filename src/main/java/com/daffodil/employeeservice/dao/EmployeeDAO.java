package com.daffodil.employeeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daffodil.employeeservice.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long> { 

}
