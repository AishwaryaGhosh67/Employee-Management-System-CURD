package com.java.CURD_springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.CURD_springBoot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
