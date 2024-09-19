package com.vladproduction.springbootrestapi.controller;

import com.vladproduction.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/response")
public class StudentResponseEntityController {

    /*  http://localhost:8080/response/student
        [GET]: REST API */
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "John", "Doe");

//        return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok(student); //with static method
    }

    /*  http://localhost:8080/response/studentHeader
        [GET]: REST API */
    @GetMapping("/studentHeader")
    public ResponseEntity<Student> getStudentHeader() {
        Student student = new Student(1, "John", "Doe");

        return ResponseEntity.ok()
                .header("custom-header", "SoftwareDev")
                .body(student);
    }

    /*  http://localhost:8080/response/students
        [GET]: Spring Boot REST API */
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1, "John", "Doe");
        Student student2 = new Student(2, "Jack", "Stone");
        Student student3 = new Student(3, "Bob", "Black");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        return ResponseEntity.ok(students);
    }

    /*  http://localhost:8080/response/studentById/1
        [GET]: Spring Boot REST API with Path Variable
        {id} - URL template variable; reiterative path params and allow to extract variables
        from URL path for using in controller method */
    @GetMapping("/studentById/{id}")
    public ResponseEntity<Student> studentById(@PathVariable("id") int studentId) {

        Student student = new Student(1, "John", "Doe");
        return ResponseEntity.ok(student);
    }

    /*  http://localhost:8080/response/studentPathVariables/1/John/Doe
        [GET]: Spring Boot REST API with Path Variables */
    @GetMapping("/studentPathVariables/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariables(@PathVariable("id") int studentId,
                                        @PathVariable("first-name") String firstName,
                                        @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    /*  http://localhost:8080/response/studentQueryById?id=1
        [GET]: Spring Boot REST API with Request Param */
    @GetMapping("/studentQueryById")
    public ResponseEntity<Student> studentQueryById(@RequestParam int id) {
        Student student = new Student(id, "firstName", "lastName");
        return ResponseEntity.ok(student);
    }

    /*  http://localhost:8080/response/studentQueryByParams?id=1&firstName=John&lastName=Doe
        [GET]: Spring Boot REST API with Request Parameters */
    @GetMapping("/studentQueryByParams")
    public ResponseEntity<Student> studentQueryByParams(@RequestParam("id") int id,
                                        @RequestParam("firstName") String firstName,
                                        @RequestParam("lastName") String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    /*  http://localhost:8080/response/createStudent
        [POST]: Spring Boot REST API to handle HTTP Post Request
        @PostMapping and @RequestBody */
    @PostMapping("/createStudent")
//    @ResponseStatus(HttpStatus.CREATED) //201
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    /*  http://localhost:8080/response/students/{id}/updateStudent
        [PUT]: Spring Boot REST API to handle HTTP Put Request - updating exist resource
        HttpStatus by default is 200 for PUT */
    @PutMapping("/students/{id}/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return ResponseEntity.ok(student);
    }

    /*  http://localhost:8080/response/students/{id}/deleteStudent
        [DELETE]: Spring Boot REST API to handle HTTP Delete Request - deleting existing resource
        HttpStatus by default is 200 for DELETE */
    @DeleteMapping("/students/{id}/deleteStudent")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        String body = "Student deleted successfully!";
        return ResponseEntity.ok(body);
    }

}
