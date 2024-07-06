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
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
//		// create the Instructor
//		Instructor instructor = new Instructor("Yang", "Nguyen", "yangkees21@gmail.com");
//
//		// create instructor detail
//		InstructorDetail instructorDetail = new InstructorDetail("Yang no Nihongo", "Japanese");

		// create the Instructor
		Instructor instructor = new Instructor("Sungha", "Jung", "sunghajug@gmail.com");

		// create instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("https://youtube.com/sunghajung", "Guitar");

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

	public void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("The ID you want to find : " + theId);
		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("Found Instructor : " + instructor);
		System.out.println("Instructor detail : " + instructor.getInstructorDetail());
	}

	public void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("The ID you want to delete : " + theId);
		appDAO.deleteInstrctorById(theId);
		System.out.println("Delete Successfully !!");
	}

}
