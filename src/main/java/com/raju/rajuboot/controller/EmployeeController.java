package com.raju.rajuboot.controller;

import com.raju.rajuboot.model.Employee;
import com.raju.rajuboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model)
    {
      model.addAttribute("listEmployee",employeeService.getAllEmployee());
      return "index";
    }

    @GetMapping("/showEmployeeForm")
    public String showEmployeeForm(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "newEmployee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("/updateEmp/{id}")
    public String updateEmp(@PathVariable(value = "id") int id, Model model)
    {
        Employee employee  = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "updatEmp";
    }
    @GetMapping("deleteEmp/{id}")
    public String deleteEmp(@PathVariable(value = "id")int id){
        this.employeeService.deleteEmp(id);
        return "redirect:/";
    }
}
