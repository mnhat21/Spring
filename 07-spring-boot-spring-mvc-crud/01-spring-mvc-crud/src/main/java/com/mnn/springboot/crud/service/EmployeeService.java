package com.mnn.springboot.crud.service;

import com.mnn.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAll();

    public Employee getById(int id);

    public Employee save(Employee employee);

    public void deleteById(int id);
}
