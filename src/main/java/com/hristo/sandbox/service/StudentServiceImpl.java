package com.hristo.sandbox.service;

import com.hristo.sandbox.dao.StudentRepository;
import com.hristo.sandbox.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    // find all
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        // get the object from the db
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Did not find student with id " + id));
    }

    @Override
    public Student save(Student student) {
        double studentGrade = student.getGradeAvg();

        if(studentGrade < 2.00 || studentGrade > 6.00){
            throw new IllegalArgumentException("Invalid grade!");
        }

        return studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
