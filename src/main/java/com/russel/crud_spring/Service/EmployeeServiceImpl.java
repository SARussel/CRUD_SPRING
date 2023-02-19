package com.russel.crud_spring.Service;

import com.russel.crud_spring.Model.Employee;
import com.russel.crud_spring.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addNewEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
