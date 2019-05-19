package com.cinema.app.cmsapp.controller;

import com.cinema.app.cmsapp.entity.Employee;
import com.cinema.app.cmsapp.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        List<Employee> employeesList = employeeService.getAllEmployees();

        model.addAttribute("employeesList", employeesList);

        return "employees/employeeList.html";
    }

    @GetMapping("/showEmployeeAddForm")
    public String showEmployeeAddForm(Model model)
    {
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employees/employeeAddForm";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeService.saveEmployee(employee);

        return "redirect:/employees/list";
    }
}
