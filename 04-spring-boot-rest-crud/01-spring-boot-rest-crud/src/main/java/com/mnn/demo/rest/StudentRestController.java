package com.mnn.demo.rest;

import com.mnn.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... onlu once !!

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Nhat", "Nguyen"));
        theStudents.add(new Student("Phuong", "Ha"));
        theStudents.add(new Student("Hai", "Hua"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        if (studentId < 0 || studentId > theStudents.size()){
            throw new StudentNotFoundException("Student with ID " + studentId +  " not found !!");
        }
        return theStudents.get(studentId);
    }
}
