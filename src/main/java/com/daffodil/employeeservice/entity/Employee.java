package com.daffodil.employeeservice.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.daffodil.employeeservice.enums.EmployeeType;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
  
  @Id
  @GeneratedValue
  @Column(name ="emp_id" , nullable = false)
  private long id;
  
  @Column(name="first_name", nullable = false, length = 50)
  private String firstName;
  
  @Column(name="last_name", nullable = false, length = 50)
  private String lastName;
  
  @Column(name="email", nullable = true, length = 50)
  private String email;
  
  @Column(name="mobile", nullable = true, length = 10)
  private long mobile;
  
  @Temporal(TemporalType.DATE)
  @Column(name = "date_of_birth", nullable = false )
  private Date dob;
  
  @Column(name = "emp_type", nullable = false )
  @Enumerated(EnumType.STRING)
  private EmployeeType type;
  
  @ManyToOne
  @JoinColumn(name = "dept_id")
  private Department department;
  
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL, mappedBy = "employee")
  
  private Set<Address> address;
  
  @Column(name = "created_by" , length = 60, nullable = false) 
  private String createdBy;

  public Set<Address> getAddress() {
    return address;
  }

  public void setAddress(Set<Address> address) {
    this.address = address;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getMobile() {
    return mobile;
  }

  public void setMobile(long mobile) {
    this.mobile = mobile;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public EmployeeType getType() {
    return type;
  }

  public void setType(EmployeeType type) {
    this.type = type;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }
  
  

}
