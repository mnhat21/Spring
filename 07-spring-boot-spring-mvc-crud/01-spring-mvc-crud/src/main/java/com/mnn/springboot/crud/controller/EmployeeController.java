package com.mnn.springboot.crud.controller;

import com.mnn.springboot.crud.entity.Employee;
import com.mnn.springboot.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add a mapping for "/list"
    @GetMapping
    public String listEmployee(Model model) {

        // get employees from db
        List<Employee> theEmployees = employeeService.getAll();
        
        // add to spring model
        model.addAttribute("employees", theEmployees);

        return "list-employees";
    }

}
