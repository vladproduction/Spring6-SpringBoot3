package com.vladproduction.springbootstudentmanagementsystemwebmvc.service.impl;

import com.vladproduction.springbootstudentmanagementsystemwebmvc.dto.StudentDto;
import com.vladproduction.springbootstudentmanagementsystemwebmvc.entity.Student;
import com.vladproduction.springbootstudentmanagementsystemwebmvc.mapper.StudentMapper;
import com.vladproduction.springbootstudentmanagementsystemwebmvc.repository.StudentRepository;
import com.vladproduction.springbootstudentmanagementsystemwebmvc.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students  = studentRepository.findAll();
        List<StudentDto> studentDtoList = students.stream()
                .map(StudentMapper::mapToStudentDto)
                .toList();
        return studentDtoList;
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        studentRepository.save(StudentMapper.mapToStudent(studentDto));
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
