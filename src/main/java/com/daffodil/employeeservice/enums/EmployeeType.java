package com.daffodil.employeeservice.enums;

public enum EmployeeType {

  FULLTIME("Full Time"), PARTTIME("Part-Time"), FIXEDTERM("Fixed Term");

  private String value;

  private EmployeeType(String val) {
    value = val;
  }

  public String getValue() {
    return value;
  }

}
