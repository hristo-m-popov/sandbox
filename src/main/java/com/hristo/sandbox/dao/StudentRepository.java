package com.hristo.sandbox.dao;

import com.hristo.sandbox.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
