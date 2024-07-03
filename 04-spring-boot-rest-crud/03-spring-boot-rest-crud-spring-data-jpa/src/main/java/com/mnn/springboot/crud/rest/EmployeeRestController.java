package com.mnn.springboot.crud.rest;

import com.mnn.springboot.crud.entity.Employee;
import com.mnn.springboot.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.getById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Can not find Employee !!");
        }
        return employee;
    }

    @PutMapping("/employee/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int employeeId) {
        employee.setId(employeeId);
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.getById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Can not find Employee !!");
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee with ID " + employeeId;
    }
}
