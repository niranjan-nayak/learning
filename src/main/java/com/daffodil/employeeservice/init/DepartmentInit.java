package com.daffodil.employeeservice.init;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.daffodil.employeeservice.dao.DepartmentDAO;
import com.daffodil.employeeservice.dao.EmployeeDAO;
import com.daffodil.employeeservice.entity.Address;
import com.daffodil.employeeservice.entity.Department;
import com.daffodil.employeeservice.entity.Employee;
import com.daffodil.employeeservice.enums.EmployeeType;

@Component
public class DepartmentInit implements ApplicationRunner {

  private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
  
  private DepartmentDAO departmentDAO;
  
  @Autowired
  private EmployeeDAO employeeDAO;

  @Autowired
  public DepartmentInit(DepartmentDAO departmentDAO) {
    this.departmentDAO = departmentDAO;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    long count = departmentDAO.count();
    if(count > 0) 
        return;
    
      Department itDep = new Department();
      itDep.setName("IT");
      itDep.setDesciprtion("Software,Hardware,Networking");
      itDep.setCreatedBy("System");
      
      Department adminDep = new Department();
      adminDep.setName("Admin");
      adminDep.setDesciprtion("General Admin");
      adminDep.setCreatedBy("System");
      
      departmentDAO.save(itDep);
      departmentDAO.save(adminDep);
      this.saveEmployee();

  }
  public void saveEmployee() throws ParseException
  {
      Employee employee = new Employee();
      employee.setFirstName("Amit");
      employee.setLastName("Gupta");
      employee.setEmail("amit.gupta@gmail.com");
      employee.setMobile(9090123321L);
      employee.setType(EmployeeType.FULLTIME);
      Date dob = df.parse("1985-11-11");
      employee.setDob(dob);
      Optional<Department> findById = departmentDAO.findById(1L);
      employee.setDepartment(findById.get());
      employee.setCreatedBy("System");
      
      
      Address employeeAddress1 = new Address ();
      employeeAddress1.setStreet("Street 1");
      employeeAddress1.setCity("City 1");
      employeeAddress1.setCountry("Country 1");
      employeeAddress1.setState("State 1");
      employeeAddress1.setEmployee(employee);
      
      
      Address  employeeAddress2 = new Address ();
      employeeAddress2.setStreet("Street 2");
      employeeAddress2.setCity("City 2");
      employeeAddress2.setCountry("Country 2");
      employeeAddress2.setState("State 2");
      employeeAddress2.setEmployee(employee);
      
      Set<Address > employeeAddressSet = new HashSet<>();
      employeeAddressSet.add(employeeAddress1);
      employeeAddressSet.add(employeeAddress2);
      
      employee.setAddress(employeeAddressSet);
      
      employeeDAO.save(employee);
      
      System.out.println("Employee and Employee Address saved successfully!!");
  }

}
