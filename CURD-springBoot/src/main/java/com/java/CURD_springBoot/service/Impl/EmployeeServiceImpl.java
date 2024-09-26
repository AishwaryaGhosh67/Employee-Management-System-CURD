package com.java.CURD_springBoot.service.Impl;

// import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.CURD_springBoot.dto.EmployeeDto;
import com.java.CURD_springBoot.entity.Employee;
import com.java.CURD_springBoot.exception.ResourceNotFoundException;
import com.java.CURD_springBoot.mapper.EmployeeMapper;
import com.java.CURD_springBoot.repository.EmployeeRepository;
import com.java.CURD_springBoot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(
						() -> new ResourceNotFoundException("Employee is not exist with given id : " + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {

		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));

		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());

		Employee updatedEmployeeObj = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {

		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));

		employeeRepository.deleteById(employeeId);
	}

}
