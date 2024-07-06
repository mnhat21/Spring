package com.mnn.cruddemo;

import com.mnn.cruddemo.dao.AppDAO;
import com.mnn.cruddemo.dao.AppDAOImpl;
import com.mnn.cruddemo.entity.Course;
import com.mnn.cruddemo.entity.Instructor;
import com.mnn.cruddemo.entity.InstructorDetail;
import com.mnn.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findInstructorByIdJoinFetch(appDAO);
			createCourseAndReview(appDAO);
		};
	}

	public void findIntructorDetailById(AppDAO appDAO) {
		int id = 1;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Found Instructor Detail : " + instructorDetail);
		System.out.println("Associated Instructor : " + instructorDetail.getInstructor());
	}

	public void deleteIntructorDetailById(AppDAO appDAO) {
		int id = 1;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Delete Instructor Detail Successfully -> " + instructorDetail);
	}

	public void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("The ID you want to delete : " + theId);
		appDAO.deleteInstrctorById(theId);
		System.out.println("Delete Successfully !!");
	}

	public void createInstructorWithCourses(AppDAO appDAO) {
		// create the Instructor
		Instructor instructor = new Instructor("Sungha", "Jung", "sunghajug@gmail.com");

		// create instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("https://youtube.com/sunghajung", "Guitar");

		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// create some courses
		Course tempCourses1 = new Course("Canon in D");
		Course tempCourses2 = new Course("Sun flower");
		Course tempCourses3 = new Course("River flows in you");

		instructor.addCourse(tempCourses1);
		instructor.addCourse(tempCourses2);
		instructor.addCourse(tempCourses3);

		// save the instructor
		//
		// NOTE : this will also save the courses
		// Cause of CascadeType.PERSIST
		System.out.println("Saving constructor : " + instructor);
		appDAO.save(instructor);
		System.out.println("The course : " + instructor.getCourse());

		System.out.println("!! Saved completed !!");
	}

	public void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("Found Instructor -> " + instructor);
		System.out.println("Associated Courses -> " + appDAO.findCourseByInstructorId(theId));
	}

	public void findInstructorByIdJoinFetch(AppDAO appDAO) {
		int theId = 1;
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Found Instructor -> " + instructor);
		System.out.println("Associated Courses -> " + instructor.getCourse());
	}

	public void createCourseAndReview(AppDAO appDAO) {
		// create the Instructor
		Course course = new Course("River flows in you");

		// create some courses
		Review review1 = new Review("I loved it !!");
		Review review2 = new Review("Nice course");
		Review review3 = new Review("Instructor's so handsome <3");

		course.addReview(review1);
		course.addReview(review2);
		course.addReview(review3);

		// save the course
		//
		// NOTE : this will also save the reviews
		// Cause of CascadeType.PERSIST

		System.out.println("Saving course : " + course);
		appDAO.saveCourse(course);
		System.out.println("Reviews : " + course.getReviews());

		System.out.println("!! Saved completed !!");
	}
}
