package com.daffodil.employeeservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.daffodil.employeeservice.dao.EmployeeDAO;
import com.daffodil.employeeservice.entity.Employee;

@RestController("/")
public class EmployeeController {
  private EmployeeDAO employeeDAO;

  @Autowired
  private EmployeeController(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }
  
  @GetMapping("employees")
  private List<Employee> getAll(){
    return employeeDAO.findAll();
  }
  
  @GetMapping("employees/{id}")
  private ResponseEntity<Employee> get(@PathVariable long id){
    Optional<Employee> findById = employeeDAO.findById(id);
    if(findById.isPresent()) {
      return ResponseEntity.ok(findById.get());
    }
    return ResponseEntity.notFound().build();
  }
  
  @DeleteMapping("employees/{id}")
  private ResponseEntity delete(@PathVariable long id){
    System.out.println(id);
    employeeDAO.deleteById(id);
    
    return ResponseEntity.ok().build();
  }
  
  

}
