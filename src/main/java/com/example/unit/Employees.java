package com.example.unit;

import java.util.List;

public class Employees {
    private List<Employee> list;

    public void setEmployeeList(List<Employee> list) {
        this.list = list;
    }

    public List<Employee> getEmployeeList() {
        return list;
    }
//    employees.setEmployeeList(Arrays.asList(employee1, employee2));
//
//    when(employeeDAO.getAllEmployees()).thenReturn(employees);
//
//    // when
//    Employees result = employeeController.getEmployees();
//
//    // then
//    assertThat(result.getEmployeeList().size()).isEqualTo(2);
//
//    assertThat(result.getEmployeeList().get(0).getFirstName())
//            .isEqualTo(employee1.getFirstName());
//
//    assertThat(result.getEmployeeList().get(1).getFirstName())
//            .isEqualTo(employee2.getFirstName());
}
