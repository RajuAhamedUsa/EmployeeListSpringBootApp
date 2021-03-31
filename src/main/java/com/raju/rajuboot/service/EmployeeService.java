package com.raju.rajuboot.service;

import com.raju.rajuboot.model.Employee;
import com.raju.rajuboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee employee1 = null;
        if(employee.isPresent()){
            employee1 = employee.get();
        }
        else {
            throw new RuntimeException("Not found");
        }
        return employee1;
    }

    @Override
    public void deleteEmp(int id) {

        this.employeeRepository.deleteById(id);
    }

}
