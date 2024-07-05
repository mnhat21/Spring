package com.mnn.springboot.thymeleafdemo.dao;

import com.mnn.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAll();

    public Employee getById(int id);

    public Employee save(Employee employee);

    public void deleteById(int id);
}
