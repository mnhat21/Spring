package com.mnn.cruddemo;

import com.mnn.cruddemo.dao.AppDAO;
import com.mnn.cruddemo.dao.AppDAOImpl;
import com.mnn.cruddemo.entity.Instructor;
import com.mnn.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// findIntructorDetailById(appDAO);
			// deleteIntructorDetailById(appDAO);
			createInstructor(appDAO);
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

	private void createInstructor(AppDAO appDAO) {
		// create the Instructor
//		Instructor instructor = new Instructor("Yang", "Nguyen", "yangkees21@gmail.com");
//
//		// create instructor detail
//		InstructorDetail instructorDetail = new InstructorDetail("Yang no Nihongo", "Japanese");

//		// create the Instructor
		Instructor instructor = new Instructor("Sungha", "Jung", "sunghajug@gmail.com");

		// create instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("https://youtube.com/sunghajung", "Guitar");
//
		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// save the instructor
		//
		// NOTE : this will also save the instructor detail
		// Cause of CascadeType.ALL
		//
		System.out.println("Saving constructor : " + instructor);
		appDAO.save(instructor);
	}
}
