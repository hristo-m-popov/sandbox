package com.hristo.sandbox.controller;

import com.hristo.sandbox.entity.Teacher;
import com.hristo.sandbox.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherMvcController {

    private final TeacherService teacherService;

    public TeacherMvcController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("/list")
    public String getAllTeachers(Model model){

        List<Teacher> teacherList = teacherService.findAll();

        model.addAttribute("teachers", teacherList);

        return "teachers/teachers";
    }

    @GetMapping("/showAddTeacherForm")
    public String showAddTeacherForm(Model model){
        Teacher teacher = new Teacher();

        model.addAttribute("teacher", teacher);

        return "/teachers/teacher-form";
    }

    @PostMapping("/save")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher){
        teacherService.save(teacher);

        return "redirect:/teachers/list";
    }
}
