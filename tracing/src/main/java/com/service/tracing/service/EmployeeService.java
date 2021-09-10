package com.service.tracing.service;

import com.service.tracing.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(long employeeId);

    Employee createEmployee(Map employeeBody);

    void deleteEmployee(long employeeId);
}
