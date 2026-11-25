package com.hristo.sandbox.controller;

import com.hristo.sandbox.entity.Teacher;
import com.hristo.sandbox.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TeacherMvcController {

    private final TeacherService teacherService;

    public TeacherMvcController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers-page")
    public String getAllTeachers(Model model){

        List<Teacher> teacherList = teacherService.findAll();

        model.addAttribute("teachers", teacherList);

        return "teachers";
    }
}
