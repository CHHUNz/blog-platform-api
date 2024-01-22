package com.kosign.dev.service.employee;

import com.kosign.dev.domain.employee.Employee;
import com.kosign.dev.payload.employee.EmployeeRequest;

public interface EmployeeService {
    void insertEmployee(EmployeeRequest employeeRequest);
    Object getAllEmployees();
    Object getEmployeeById(Long id);
    void updateEmployee(EmployeeRequest payload, Long id);
    void deleteEmployee(Long id);
}
