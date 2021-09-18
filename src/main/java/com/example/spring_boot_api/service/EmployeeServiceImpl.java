package com.example.spring_boot_api.service;

import com.example.spring_boot_api.error.EmployeeNotFoundException;
import com.example.spring_boot_api.repository.EmployeeRepository;
import com.example.spring_boot_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllemployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if ((!employee.isPresent())) {
            throw new EmployeeNotFoundException("Employee not found!");
        }
        return employee.get();
    }

    @Override
    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployeeById(Long employeeId, Employee employee) {

        Employee e = employeeRepository.findById(employeeId).get();
        e.setEmail(employee.getEmail());
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        return employeeRepository.save(e);
    }
}
