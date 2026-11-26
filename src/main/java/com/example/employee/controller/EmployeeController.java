package com.example.employee.controller;

import com.example.employee.entity.dtos.EmployeeRequest;
import com.example.employee.entity.dtos.EmployeeResponse;
import com.example.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    @PostMapping("/create-employee")
    public EmployeeResponse createEmployee(EmployeeRequest request)
    {
        return employeeService.createEmployee(request);
    }

    @GetMapping("/get-all-employee")
    public List<EmployeeResponse> getAllResponse()
    {
        return employeeService.getAllEmployees();
    }
    // Get Employee By ID
    @GetMapping("/get-employee/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable UUID id) {

        return employeeService.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping("/update-employee/{id}")
    public EmployeeResponse updateEmployee(
            @PathVariable UUID id,
            @RequestBody EmployeeRequest request) {

        return employeeService.updateEmployee(id, request);
    }

    // Delete Employee
    @DeleteMapping("/delete-employee/{id}")
    public void deleteEmployee(@PathVariable UUID id) {

        employeeService.deleteEmployee(id);


    }
}
