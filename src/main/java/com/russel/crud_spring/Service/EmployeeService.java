package com.russel.crud_spring.Service;

import com.russel.crud_spring.Model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeService {
    List<Employee> getAllEmployees();
}
