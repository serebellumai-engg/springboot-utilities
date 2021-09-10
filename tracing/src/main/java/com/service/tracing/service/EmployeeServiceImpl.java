package com.service.tracing.service;

import com.service.tracing.entity.Employee;
import com.service.tracing.repo.EmployeeRepository;
import com.service.tracing.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public Employee createEmployee(Map employeeBody) {
        Employee employee = (Employee) JacksonUtil.convertMapToObject(employeeBody, Employee.class);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
