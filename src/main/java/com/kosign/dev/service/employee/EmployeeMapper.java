package com.kosign.dev.service.employee;

import com.kosign.dev.domain.employee.Employee;
import com.kosign.dev.domain.employee.EmployeeRepository;
import com.kosign.dev.payload.employee.EmployeeRequest;
import com.kosign.dev.payload.employee.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {
    private final EmployeeRepository employeeRepository;
    public Employee mapToEntity(EmployeeRequest payload){
        return Employee.builder()
                .fullName(payload.fullName())
                .email(payload.email())
                .role(payload.role())
                .build();
    }

    public EmployeeResponse mapToResponse(Employee employee){
        return EmployeeResponse.builder()
                .id(employee.getId())
                .fullName(employee.getFullName())
                .email(employee.getEmail())
                .role(employee.getRole())
                .build();
    }


}
