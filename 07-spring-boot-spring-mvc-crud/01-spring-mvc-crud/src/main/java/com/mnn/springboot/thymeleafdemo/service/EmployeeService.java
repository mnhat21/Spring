package com.mnn.springboot.thymeleafdemo.service;

import com.mnn.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAll();

    public Employee getById(int id);

    public Employee save(Employee employee);

    public void deleteById(int id);
}
