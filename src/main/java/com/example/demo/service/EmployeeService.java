package com.example.demo.service;

import com.example.demo.repository.EmployeeRepository;

import java.util.List;

import com.example.demo.beans.Employee;
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

    public Employee createEmployee(Employee employee,MultipartFile file) {
        Employee e = new Employee();
        try{
        // e=new Employee(employee.getId(),employee.getChannel(),employee.getName(),employee.getAge(),e.getFiles());
        }
        catch(Exception ex)
        {
            System.out.println("Error");
        }
        return employeeRepository.save(e);
    }

    public Employee saveFile(Employee e,MultipartFile file) {
        try {
            System.out.println("Here");
           // e.setFiles(file.getBytes());
        }
        catch(Exception ex) {
           // ex.printStackTrace();
        }
        
        return employeeRepository.save(e);
    }

}