package com.example.custom_query.repository;

import com.example.custom_query.dto.EmployeeDTO;
import com.example.custom_query.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.salary between :min and :max")
    List<Employee> findBySalaryBetween(@Param("min") BigDecimal min, @Param("max") BigDecimal max );

    @Query("select e from Employee e where e.role in :roles")
    List<Employee> findBYRoleIn(@Param("roles") List<String> roles);

    @Query("SELECT e FROM Employee e WHERE e.department NOT IN :departments")
    List<Employee> findByDepartmentNotIn(@Param("departments") List<String> departments);

    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Employee> searchByName(@Param("keyword") String keyword);

    @Query("SELECT e FROM Employee e WHERE e.role = :role AND e.salary > :salary")
    List<Employee> findByRoleAndSalaryGreaterThan(@Param("role") String role, @Param("salary") BigDecimal salary);

    @Query("SELECT new com.example.custom_query.dto.EmployeeDTO(e.name, e.role) FROM Employee e WHERE e.role IN :roles")
    List<EmployeeDTO> findEmployeeDTOByRole(@Param("roles") List<String> roles);
}
