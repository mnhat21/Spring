package com.mnn.springboot.crud;

import com.mnn.springboot.crud.dao.EmployeeDAOImpl;
import com.mnn.springboot.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

    private EmployeeDAOImpl employeeService;

    @Autowired
    public EmployeeRestController(EmployeeDAOImpl employeeDAOImpl) {
        employeeService = employeeDAOImpl;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return employeeService.getAll();
    }

    @GetMapping("employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.getById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Can not find Employee !!");
        }
        return employee;
    }
}
