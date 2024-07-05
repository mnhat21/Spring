package com.mnn.springboot.crud.dao;

import com.mnn.springboot.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee ", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee getById(@PathVariable int id) {
        Employee emp = entityManager.find(Employee.class, id);
        return emp;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Employee emp = entityManager.find(Employee.class, id);
        entityManager.remove(emp);
    }
}
