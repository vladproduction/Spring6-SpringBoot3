package com.vladproduction.springbootwebfluxtutorial.service.impl;

import com.vladproduction.springbootwebfluxtutorial.dto.EmployeeDto;
import com.vladproduction.springbootwebfluxtutorial.entity.Employee;
import com.vladproduction.springbootwebfluxtutorial.mapper.EmployeeMapper;
import com.vladproduction.springbootwebfluxtutorial.repository.EmployeeRepository;
import com.vladproduction.springbootwebfluxtutorial.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);
        return savedEmployee.map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String employeeId) {
        Mono<Employee> savedEmployee = employeeRepository.findById(employeeId);
        return savedEmployee.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {
        Flux<Employee> employeesFlux = employeeRepository.findAll();
        return employeesFlux.map(EmployeeMapper::mapToEmployeeDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String employeeId) {

        Mono<Employee> employeeMono = employeeRepository.findById(employeeId);

        Mono<Employee> updated = employeeMono.flatMap((existing) -> {
           existing.setFirstName(employeeDto.getFirstName());
           existing.setLastName(employeeDto.getLastName());
           existing.setEmail(employeeDto.getEmail());

           return employeeRepository.save(existing);
        });
        return updated.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Mono<Void> deleteEmployee(String employeeId) {
        return employeeRepository.deleteById(employeeId);
    }
}
