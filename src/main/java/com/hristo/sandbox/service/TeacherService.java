package com.hristo.sandbox.service;

import com.hristo.sandbox.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();
    Teacher findById(int id);
    Teacher save(Teacher teacher);
    void deleteById(int id);
}
