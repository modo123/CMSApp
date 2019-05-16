package com.cinema.app.cmsapp.service;

import com.cinema.app.cmsapp.dao.EmployeeRepository;
import com.cinema.app.cmsapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }
}
