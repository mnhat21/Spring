package com.mnn.springboot.thymeleafdemo.controller;

import com.mnn.springboot.thymeleafdemo.entity.Employee;
import com.mnn.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String processForAdd(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@PathVariable int employeeId, Model model) {
        model.addAttribute(employeeService.getById(employeeId));
        return "employees/employee-form";
    }

    @PutMapping("/save")
    public String processForUpdate(@ModelAttribute Employee employee, Model model) {
        employeeService.save(employee);
        return "redirect:/employee/list";
    }
}
