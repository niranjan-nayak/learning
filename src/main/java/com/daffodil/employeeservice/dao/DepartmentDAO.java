package com.daffodil.employeeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daffodil.employeeservice.entity.Department;

@Repository
public interface DepartmentDAO extends JpaRepository<Department, Long> {

  
  
}
