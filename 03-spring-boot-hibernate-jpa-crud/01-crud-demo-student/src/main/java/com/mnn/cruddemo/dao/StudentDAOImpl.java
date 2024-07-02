package com.mnn.cruddemo.dao;

import com.mnn.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        // save the student method
        entityManager.persist(student);
    }

    // implement find by id method
    @Override
    public Student findById(int id) {
        // find the student
        Student std = entityManager.find(Student.class, id);
        return std;
    }

    // implement find all method
    @Override
    public List<Student> findAll() {
        // create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return result
        return theQuery.getResultList();
    }

    // implement find by name method
    @Override
    public List<Student> findByName(String name) {
        // create Query
        TypedQuery<Student> theQuery = entityManager
                .createQuery("FROM Student s WHERE s.firstName LIKE :pattern", Student.class);

        // set query parameter
        theQuery.setParameter("pattern", "%" + name + "%");

        // return result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }
}
