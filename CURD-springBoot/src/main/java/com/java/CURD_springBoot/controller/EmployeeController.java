package com.java.CURD_springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.CURD_springBoot.dto.EmployeeDto;
import com.java.CURD_springBoot.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // BUILD ADD EMPLOYEE REST API

    @PostMapping("/createEmp")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // BUILD GET EMPLOYEE REST API
    @GetMapping("/getEmp/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    // BUILD GET ALL EMPLOYEES REST API
    @GetMapping("/getAllEmp")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // BUILD UPDATE EMPLOYEE REST API
    @PutMapping("/updateEmp/{id}")
    public ResponseEntity<EmployeeDto> updatedEmployeEntity(@PathVariable("id") Long employeeId,
            @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    // BUILD DELETE EMPLOYEE BY ID REST API
    @DeleteMapping("/deleteEmp/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {

        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully!");
    }
}
