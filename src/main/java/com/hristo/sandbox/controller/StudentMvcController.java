package com.hristo.sandbox.controller;

import com.hristo.sandbox.entity.Student;
import com.hristo.sandbox.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentMvcController {
    private final StudentService studentService;

    public StudentMvcController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/students-page")
    public String getStudents(Model model){
        List<Student> studentsList = studentService.findAll();

        model.addAttribute("students", studentsList);

        return "students";
    }
}
