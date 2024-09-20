package com.vladproduction.springbootwebfluxtutorial.controller;

import com.vladproduction.springbootwebfluxtutorial.dto.EmployeeDto;
import com.vladproduction.springbootwebfluxtutorial.repository.EmployeeRepository;
import com.vladproduction.springbootwebfluxtutorial.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerIntegrationTest {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void before(){
        System.out.println("Before Each Test");
        employeeRepository.deleteAll().subscribe();
    }

    @Test
    void saveEmployeeTest() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Alessandro");
        employeeDto.setLastName("Nesta");
        employeeDto.setEmail("nesta@gmail.com");
        webTestClient.post().uri("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(employeeDto), EmployeeDto.class)
                .exchange()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(employeeDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(employeeDto.getLastName())
                .jsonPath("$.email").isEqualTo(employeeDto.getEmail());
    }

    @Test
    void getSingleEmployeeTest() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Pavel");
        employeeDto.setLastName("Nedved");
        employeeDto.setEmail("nedved@gmail.com");
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto).block();

        webTestClient.get().uri("/api/employees/{id}", Collections.singletonMap("id", savedEmployee.getId()))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.id").isEqualTo(savedEmployee.getId())
                .jsonPath("$.firstName").isEqualTo(employeeDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(employeeDto.getLastName())
                .jsonPath("$.email").isEqualTo(employeeDto.getEmail());
    }

    @Test
    void getAllEmployeesTest() {

        EmployeeDto nesta = new EmployeeDto();
        nesta.setFirstName("Alessandro");
        nesta.setLastName("Nesta");
        nesta.setEmail("nesta@gmail.com");
        employeeService.saveEmployee(nesta).block();

        EmployeeDto nedved = new EmployeeDto();
        nedved.setFirstName("Pavel");
        nedved.setLastName("Nedved");
        nedved.setEmail("nedved@gmail.com");
        employeeService.saveEmployee(nedved).block();

        webTestClient.get().uri("/api/employees")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(EmployeeDto.class)
                .consumeWith(System.out::println);
    }

    @Test
    void updateEmployeeTest() {
        EmployeeDto delPiero = new EmployeeDto();
        delPiero.setFirstName("Alessandro");
        delPiero.setLastName("DelPiero");
        delPiero.setEmail("delpiero@gmail.com");
        EmployeeDto savedEmployee = employeeService.saveEmployee(delPiero).block();

        EmployeeDto updatedEmployee = new EmployeeDto();
        updatedEmployee.setFirstName("Sandro");
        updatedEmployee.setLastName("Del Piero");
        updatedEmployee.setEmail("Sandro@gmail.com");

        webTestClient.put().uri("/api/employees/{id}", Collections.singletonMap("id", savedEmployee.getId()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(updatedEmployee), EmployeeDto.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(updatedEmployee.getFirstName())
                .jsonPath("$.lastName").isEqualTo(updatedEmployee.getLastName())
                .jsonPath("$.email").isEqualTo(updatedEmployee.getEmail());

    }

    @Test
    void deleteEmployeeTest() {
        EmployeeDto delPiero = new EmployeeDto();
        delPiero.setFirstName("Alessandro");
        delPiero.setLastName("DelPiero");
        delPiero.setEmail("delpiero@gmail.com");
        EmployeeDto savedEmployee = employeeService.saveEmployee(delPiero).block();

        webTestClient.delete().uri("/api/employees/{id}", Collections.singletonMap("id", savedEmployee.getId()))
                .exchange()
                .expectStatus().isNoContent()
                .expectBody()
                .consumeWith(System.out::println);
    }
}