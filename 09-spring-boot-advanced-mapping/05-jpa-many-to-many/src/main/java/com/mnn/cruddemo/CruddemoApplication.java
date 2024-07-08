package com.mnn.cruddemo;

import com.mnn.cruddemo.dao.AppDAO;
import com.mnn.cruddemo.dao.AppDAOImpl;
import com.mnn.cruddemo.entity.*;
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
			// createCourseAndStudents(appDAO);
			retrieveCourseAndStudents(appDAO);
		};
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

	public void createCourseAndReview(AppDAO appDAO) {
		// create the Instructor
		Course course = new Course("Orange - 7!!");

		// create some courses
		Review review1 = new Review("I loved it !!");
		Review review2 = new Review("Nice course");
		Review review3 = new Review("Nice violin");

		course.addReview(review1);
		course.addReview(review2);
		course.addReview(review3);

		// save the course
		//
		// NOTE : this will also save the reviews
		// Cause of CascadeType.PERSIST

		System.out.println("Saving course : " + course);
		appDAO.save(course);
		System.out.println("Reviews : " + course.getReviews());

		System.out.println("!! Saved completed !!");
	}

	public void createCourseAndStudents(AppDAO appDAO) {
		// create a course
		Course course = new Course("Guitar with Sunghajung");

		// create the students
		Student student1 = new Student("Yang", "Nguyen", "mnn@gmail.com");
		Student student2 = new Student("Nhat", "Nguyen", "minhnhat221201@gmail.com");
		Student student3 = new Student("Phuong", "Ha", "minhminh1721@gmail.com");

		// add students to the course
		course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);

		// save the course and associated students
		System.out.println("Saved Course -> " + course);
		System.out.println("Associated student -> " + course.getStudents());
		appDAO.save(course);
	}

	public void retrieveCourseAndStudents(AppDAO appDAO) {
		int theId = 10;
		Course course = appDAO.findCourseAndStudentsByCourseId(theId);
		System.out.println("Found course -> " + course);
		System.out.println("Associated studednts -> " + course.getStudents());
	}
}
