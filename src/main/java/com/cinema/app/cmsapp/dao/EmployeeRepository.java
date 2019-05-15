package com.cinema.app.cmsapp.dao;

import com.cinema.app.cmsapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
