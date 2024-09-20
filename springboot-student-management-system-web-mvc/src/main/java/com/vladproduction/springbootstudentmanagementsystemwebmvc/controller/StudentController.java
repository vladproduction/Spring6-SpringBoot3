package com.vladproduction.springbootstudentmanagementsystemwebmvc.controller;

import com.vladproduction.springbootstudentmanagementsystemwebmvc.dto.StudentDto;
import com.vladproduction.springbootstudentmanagementsystemwebmvc.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    //method to handle list students request
    // http://localhost:8080/students
    @GetMapping("/students")
    public String listStudents(Model model){
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    //handler method to handle new Student request
    // http://localhost:8080/students/new
    @GetMapping("/students/new")
    public String newStudent(Model model){
        //create student object to store into db
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create-student";
    }

    //handler method to handle save Student form submit request
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto student,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("student", student);
            return "create-student";

        }
        studentService.createStudent(student);
        return "redirect:/students";
    }

    //handler method to handle edit Student request
    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId,
                              Model model){
        StudentDto student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        return "edit-student";
    }

    //handler method to handle edit Student form submit request
    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @Valid @ModelAttribute("student") StudentDto student,
                                BindingResult result,
                                Model model){
        if (result.hasErrors()){
            model.addAttribute("student", student);
            return "edit-student";
        }
        student.setId(studentId);
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    //handler method to handle delete student request
    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    //handler method to handle student view request
    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId,
                              Model model){
        StudentDto studentDto = studentService.getStudentById(studentId);
        model.addAttribute("student", studentDto);
        return "view-student";

    }




}
