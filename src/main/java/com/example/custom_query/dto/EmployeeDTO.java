package com.example.custom_query.dto;

import lombok.Getter;

@Getter
public class EmployeeDTO {
    private String name;
    private String role;

    public EmployeeDTO(String name, String role) {
        this.name = name;
        this.role = role;
    }
}

