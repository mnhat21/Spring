package com.mnn.springboot.crud.dao;

import com.mnn.springboot.crud.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAll();

    public Employee getById(int id);

    public Employee save(Employee employee);

    public void deleteById(int id);
}
