package com.hristo.sandbox.controller;

import com.hristo.sandbox.entity.Student;
import com.hristo.sandbox.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentMvcController {
    private final StudentService studentService;

    public StudentMvcController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String getStudents(Model model){
        List<Student> studentsList = studentService.findAll();

        model.addAttribute("students", studentsList);

        return "students";
    }
}
