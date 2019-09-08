package com.daffodil.employeeservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")

public class Department {

  @Id
  @GeneratedValue
  @Column(name = "Id", nullable = false)
  private Long id;

  @Column(name = "Name", length = 64, nullable = false)
  private String name;
  
  @Column(name = "Desc", length = 200, nullable = true)
  private String desciprtion;
  
  @Column(name = "created_by" , length = 60, nullable = false) 
  private String createdBy;
  

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesciprtion() {
    return desciprtion;
  }

  public void setDesciprtion(String desciprtion) {
    this.desciprtion = desciprtion;
  }
  
}
