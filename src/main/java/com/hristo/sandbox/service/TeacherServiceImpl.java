package com.hristo.sandbox.service;

import com.hristo.sandbox.dao.TeacherRepository;
import com.hristo.sandbox.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int id) {
        return teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Did not find teacher with the id: " + id));
    }

    @Override
    public Teacher save(Teacher teacher) {
        int age = teacher.getAge();

        if(age < 23 || age > 90){
            throw new IllegalArgumentException("The teacher can't be that old!");
        }

        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(int id) {
        teacherRepository.deleteById(id);
    }
}
