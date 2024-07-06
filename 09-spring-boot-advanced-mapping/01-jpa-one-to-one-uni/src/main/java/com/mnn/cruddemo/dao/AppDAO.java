package com.mnn.cruddemo.dao;

import com.mnn.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstrctorById(int theId);
}
