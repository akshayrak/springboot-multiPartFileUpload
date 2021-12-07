package com.example.demo.service;

import com.example.demo.repository.EmployeeRepository;

import java.util.List;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeesList() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        
        return employeeRepository.save(employee);
    }

    

}