package com.raju.rajuboot.service;

import com.raju.rajuboot.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {

    //this method will be used in employee service class
    List<Employee> getAllEmployee();
    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    public void deleteEmp(int id);
}
