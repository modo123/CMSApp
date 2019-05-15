package com.cinema.app.cmsapp.controller;

import com.cinema.app.cmsapp.entity.Employee;
import com.cinema.app.cmsapp.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController
{
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getEmployeeList(Model model)
    {
        List<Employee> employeeList = employeeService.getAllEmployees();

        model.addAttribute("employees", employeeList);

        return "employees/employeeList.html";
    }
}
