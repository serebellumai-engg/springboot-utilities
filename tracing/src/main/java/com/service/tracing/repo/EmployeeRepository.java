package com.service.tracing.repo;

import com.service.tracing.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("select e from Employee e where e.employeeId=:employeeId")
    Employee findById(@Param(value = "employeeId") long employeeId);
}