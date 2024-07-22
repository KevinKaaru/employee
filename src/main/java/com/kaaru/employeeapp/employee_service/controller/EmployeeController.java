package com.kaaru.employeeapp.employee_service.controller;

import com.kaaru.employeeapp.employee_service.entity.Employee;
import com.kaaru.employeeapp.employee_service.response.EmployeeResponse;
import com.kaaru.employeeapp.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
   ResponseEntity <EmployeeResponse> getEmployeeDetails(@PathVariable("id")int id){
       EmployeeResponse employeeResponse= employeeService.getEmployeeById(id);

       return  ResponseEntity.status(HttpStatus.OK).body(employeeResponse);


    }
}
