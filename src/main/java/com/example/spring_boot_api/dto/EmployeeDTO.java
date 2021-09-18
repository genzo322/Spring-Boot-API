package com.example.spring_boot_api.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


import com.example.spring_boot_api.entity.Employee;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EmployeeDTO {


    private long id;

    private String firstName;

    private String lastName;

    private String email;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
    }

}

