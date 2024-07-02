package com.mnn.cruddemo.dao;

import com.mnn.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByName(String name);

    void updateStudent(Student student);
}
