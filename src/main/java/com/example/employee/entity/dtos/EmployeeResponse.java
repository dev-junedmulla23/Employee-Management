package com.example.employee.entity.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EmployeeResponse {

    private UUID id;
    private String name;
    private String email;
    private String department;
    private Double salary;

}
