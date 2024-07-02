package com.mnn.cruddemo;

import com.mnn.cruddemo.dao.StudentDAO;
import com.mnn.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			findAllStudent(studentDAO);
		};
	}

	private static void createMultipleStudent(StudentDAO studentDAO) {
		Student std1 = new Student("Phuong", "Ha", "minhminh1721@gmail.com");
		Student std2 = new Student("Hai", "Hua", "haitk2001@gmail.com");
		Student std3 = new Student("Long", "Do", "longhcm2001@gmail.com");

		System.out.println("Saving students ...");
		studentDAO.save(std1);
		studentDAO.save(std2);
		studentDAO.save(std3);
		System.out.println("Saved Successfully !!");
	}

	private static void saveStudent(StudentDAO studentDAO) {
		// create student object
		Student std1 = new Student("Nhat", "Nguyen", "minhnhat221201@gmail.com");

		// save the student object
		studentDAO.save(std1);

		// display id of saved student;
		System.out.println("Saved student ID : " + std1.getId());
	}

	private static void findStudent(StudentDAO studentDAO) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Input Student ID : ");
		int id = ip.nextInt();
		Student std = studentDAO.findById(id);
		System.out.println("Found student : " + std);
	}

	private static void findAllStudent(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		students.forEach(s -> System.out.println(s));
	}

	private static void findByName(StudentDAO studentDAO) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Input Student 's name : ");
		String name = ip.nextLine();
		List<Student> std = studentDAO.findByName(name);
		System.out.println("Found student : " + std);
	}

	private static void updateStudent(StudentDAO studentDAO) {
		// input student
		Scanner ip = new Scanner(System.in);
		System.out.println("Input Student ID : ");
		int id = ip.nextInt();

		// Update student
		Student std = studentDAO.findById(id);
		std.setFirstName("Yang");
		studentDAO.updateStudent(std);
		System.out.println("Update student successfully !!");
	}

}
