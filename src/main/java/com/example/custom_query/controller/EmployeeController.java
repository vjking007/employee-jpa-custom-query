package com.example.custom_query.controller;

import com.example.custom_query.dto.EmployeeDTO;
import com.example.custom_query.model.Employee;
import com.example.custom_query.service.EmployeeService;;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/salary")
    public List<Employee> getBySalaryRange(@RequestParam BigDecimal min, @RequestParam BigDecimal max){
        return employeeService.getBySalaryRange(min, max);
    }

    @GetMapping("/roles")
    public List<Employee> getByRoles(@RequestParam List<String> roles){
        return employeeService.getByRoles(roles);
    }

    @GetMapping("/exclude-departments")
    public List<Employee> getByExcludedDepartments(@RequestParam List<String> departments) {
        return employeeService.getByExcludedDepartments(departments);
    }

    @GetMapping("/search")
    public List<Employee> searchByName(@RequestParam String keyword) {
        return employeeService.searchByName(keyword);
    }

    @GetMapping("/role-salary")
    public List<Employee> getByRoleAndSalary(@RequestParam String role, @RequestParam BigDecimal salary) {
        return employeeService.getByRoleAndSalary(role, salary);
    }

    @GetMapping("/dtos")
    public List<EmployeeDTO> getDTOsByRole(@RequestParam List<String> roles) {
        return employeeService.getDTOsByRoles(roles);
    }
}
