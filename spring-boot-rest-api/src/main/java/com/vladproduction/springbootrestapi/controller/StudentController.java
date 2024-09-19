package com.vladproduction.springbootrestapi.controller;

import com.vladproduction.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    /*  http://localhost:8080/student
        [GET]: REST API */
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "John", "Doe");
    }

    /*  http://localhost:8080/students
        [GET]: Spring Boot REST API */
    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1, "John", "Doe");
        Student student2 = new Student(2, "Jack", "Stone");
        Student student3 = new Student(3, "Bob", "Black");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        return students;
    }

    /*  http://localhost:8080/studentById/1
        [GET]: Spring Boot REST API with Path Variable
        {id} - URL template variable */
    @GetMapping("/studentById/{id}")
    public Student studentById(@PathVariable("id") int studentId) {
        return new Student(1, "John", "Doe");
    }

    /*  http://localhost:8080/studentPathVariables/1/John/Doe
        [GET]: Spring Boot REST API with Path Variables */
    @GetMapping("/studentPathVariables/{id}/{first-name}/{last-name}")
    public Student studentPathVariables(@PathVariable("id") int studentId,
                                        @PathVariable("first-name") String firstName,
                                        @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    /*  http://localhost:8080/studentQueryById?id=1
        [GET]: Spring Boot REST API with Request Param */
    @GetMapping("/studentQueryById")
    public Student studentQueryById(@RequestParam int id) {
        return new Student(id, "firstName", "lastName");
    }

    /*  http://localhost:8080/studentQueryByParams?id=1&firstName=John&lastName=Doe
        [GET]: Spring Boot REST API with Request Parameters */
    @GetMapping("/studentQueryByParams")
    public Student studentQueryByParams(@RequestParam("id") int id,
                                        @RequestParam("firstName") String firstName,
                                        @RequestParam("lastName") String lastName) {
        return new Student(id, firstName, lastName);
    }

    /*  http://localhost:8080/createStudent
        [POST]: Spring Boot REST API to handle HTTP Post Request
        @PostMapping and @RequestBody */
    @PostMapping("/createStudent")
    @ResponseStatus(HttpStatus.CREATED) //201
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }

    /*  http://localhost:8080/students/{id}/updateStudent
        [PUT]: Spring Boot REST API to handle HTTP Put Request - updating exist resource
        HttpStatus by default is 200 for PUT */
    @PutMapping("/students/{id}/updateStudent")
    public Student updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }

    /*  http://localhost:8080/students/{id}/deleteStudent
        [DELETE]: Spring Boot REST API to handle HTTP Delete Request - deleting existing resource
        HttpStatus by default is 200 for DELETE */
    @DeleteMapping("/students/{id}/deleteStudent")
    public String deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return "Student deleted successfully!";
    }


}
