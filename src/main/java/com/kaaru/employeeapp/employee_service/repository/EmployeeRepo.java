package com.kaaru.employeeapp.employee_service.repository;

import com.kaaru.employeeapp.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
