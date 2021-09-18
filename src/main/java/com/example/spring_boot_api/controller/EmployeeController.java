package com.example.spring_boot_api.controller;

import com.example.spring_boot_api.entity.Employee;
import com.example.spring_boot_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllemployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/employees/{id}")
    String deleteById(@PathVariable("id") Long employeeId){
        employeeService.deleteById(employeeId);
        return "OK";
    }

    @PutMapping("/employees/{id}")
    Employee updateById(@PathVariable("id") Long employeeId, @RequestBody Employee employee){
        return employeeService.updateEmployeeById(employeeId, employee);
    }
}
