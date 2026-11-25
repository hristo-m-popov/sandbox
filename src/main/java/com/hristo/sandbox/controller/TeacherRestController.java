package com.hristo.sandbox.controller;

import com.hristo.sandbox.entity.Teacher;
import com.hristo.sandbox.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherRestController {

    private final TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    // get all
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
        return teacherService.findAll();
    }

    // get by id
    @GetMapping("/teachers/{teacherId}")
    public Teacher getTeacherById(@PathVariable int teacherId){
        return teacherService.findById(teacherId);
    }

    // save
    @PostMapping("/teachers")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.save(teacher);
    }

    // update
    @PutMapping("/teachers")
    public Teacher updateTeacher(@RequestBody Teacher teacher){
        return teacherService.save(teacher);
    }

    // delete
    @DeleteMapping("/teachers/{teacherId}")
    public String deleteTeacher(@PathVariable int teacherId){
        Teacher dbTeacher = teacherService.findById(teacherId);

        if(dbTeacher == null){
            throw new RuntimeException("Did not find teacher with id - " + teacherId);
        }else{
            teacherService.deleteById(teacherId);
        }

        return "Deleted student with id - " + teacherId;
    }
}
