package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.entity.dtos.EmployeeRequest;
import com.example.employee.entity.dtos.EmployeeResponse;
import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    public final EmployeeMapper employeeMapper;
    public final EmployeeRepository employeeRepository;

    public EmployeeResponse createEmployee(EmployeeRequest request)
    {
        Employee employee = employeeMapper.toEntity(request);

        Employee saved=employeeRepository.save((employee));

        return  employeeMapper.toResponse(saved);
    }

    public List<EmployeeResponse> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponse)
                .toList();
    }

    public EmployeeResponse getEmployeeById(UUID id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Employee not found with ID: " + id
                ));

        return employeeMapper.toResponse(employee);
    }

    public EmployeeResponse updateEmployee(UUID id, EmployeeRequest request) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Employee not found with ID: " + id
                ));

        Employee updatedEmployee = employeeMapper.toEntity(request);

        Employee saved = employeeRepository.save(updatedEmployee);

        return employeeMapper.toResponse(saved);
    }

    public void deleteEmployee(UUID id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Employee not found with ID: " + id
                ));

        employeeRepository.delete(employee);
    }

}
