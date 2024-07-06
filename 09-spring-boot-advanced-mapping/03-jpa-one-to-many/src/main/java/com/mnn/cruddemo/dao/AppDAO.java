package com.mnn.cruddemo.dao;

import com.mnn.cruddemo.entity.Course;
import com.mnn.cruddemo.entity.Instructor;
import com.mnn.cruddemo.entity.InstructorDetail;
import com.mnn.cruddemo.entity.Review;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstrctorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCourseByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void deleteCourseById(int theId);

    void saveCourse(Course course);
}
