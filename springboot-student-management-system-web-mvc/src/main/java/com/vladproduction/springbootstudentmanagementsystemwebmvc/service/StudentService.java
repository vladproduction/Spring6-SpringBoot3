package com.vladproduction.springbootstudentmanagementsystemwebmvc.service;

import com.vladproduction.springbootstudentmanagementsystemwebmvc.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    List<StudentDto> getAllStudents();

    void createStudent(StudentDto student);

    StudentDto getStudentById(Long studentId);

    void updateStudent(StudentDto student);

    void deleteStudent(Long studentId);
}
