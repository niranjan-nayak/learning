package com.daffodil.employeeservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.daffodil.employeeservice.dao.DepartmentDAO;
import com.daffodil.employeeservice.entity.Department;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentDAO departmentDAO;
  
  
  public List<Department> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
  {
      Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

      Page<Department> pagedResult = departmentDAO.findAll(paging);
       
      if(pagedResult.hasContent()) {
          return pagedResult.getContent();
      } else {
          return new ArrayList<>();
      }
  }
}
