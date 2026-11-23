package com.hristo.sandbox.controller;

import com.hristo.sandbox.entity.Student;
import com.hristo.sandbox.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController {
    // dependency injection

    private final StudentService studentService;

    public StudentRestController(StudentService studentService){
        this.studentService = studentService;
    }

    // add mapping for get all students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return studentService.findById(studentId);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent){
        return studentService.save(theStudent);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student theStudent){
        return studentService.save(theStudent);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
        Student dbStudent = studentService.findById(studentId);

        if(dbStudent == null){
            throw new RuntimeException("Did not find student with id - " + studentId);
        }else{
            studentService.deleteById(studentId);
        }

        return "Deleted student with id - " + studentId;
    }

    @GetMapping("/students/numOfStudents")
    public String numOfStudents(){
        List<Student> list = studentService.findAll();

        return  "The total number of students in the school is: " + list.size();
    }

}
