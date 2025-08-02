package com.example.custom_query.service;

import com.example.custom_query.dto.EmployeeDTO;
import com.example.custom_query.model.Employee;
import com.example.custom_query.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getBySalaryRange(BigDecimal min, BigDecimal max) {
        return  employeeRepository.findBySalaryBetween(min, max);
    }

    public List<Employee> getByRoles(List<String> roles) {
        return  employeeRepository.findBYRoleIn(roles);
    }

    public List<Employee> getByExcludedDepartments(List<String> departments) {
        return employeeRepository.findByDepartmentNotIn(departments);
    }

    public List<Employee> searchByName(String name) {
        return employeeRepository.searchByName(name);
    }

    public List<Employee> getByRoleAndSalary(String role, BigDecimal salary) {
        return employeeRepository.findByRoleAndSalaryGreaterThan(role, salary);
    }

    public List<EmployeeDTO> getDTOsByRoles(List<String> roles) {
        return employeeRepository.findEmployeeDTOByRole(roles);
    }
}
