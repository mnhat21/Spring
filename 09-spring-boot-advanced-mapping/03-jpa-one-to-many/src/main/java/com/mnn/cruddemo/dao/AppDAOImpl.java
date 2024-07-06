package com.mnn.cruddemo.dao;

import com.mnn.cruddemo.entity.Course;
import com.mnn.cruddemo.entity.Instructor;
import com.mnn.cruddemo.entity.InstructorDetail;
import com.mnn.cruddemo.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstrctorById(int theId) {
        // retrieve the instructor
        Instructor instructor = findInstructorById(theId);

        // get the courses
        List<Course> courses = instructor.getCourse();

        // break association
        courses.forEach((course -> {
            course.setInstructor(null);
        }));

        // delete the instructor
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail instructorDetail = findInstructorDetailById(theId);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCourseByInstructorId(int theId) {
        // create query
        TypedQuery<Course> query = entityManager.createQuery("FROM Course WHERE instructor.id =: data", Course.class);
        query.setParameter("data", theId);

        // excute query
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        // create query
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i " +
                "join fetch i.course " +
                "where i.id =: data", Instructor.class);
        query.setParameter("data", theId);

        // excute query
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course course = entityManager.find(Course.class, theId);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }


}
