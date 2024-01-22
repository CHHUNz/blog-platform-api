package com.kosign.dev.payload.employee;

import com.kosign.dev.domain.employee.Employee;

import java.util.List;

public record EmployeeMainRes(List<EmployeeResponse> employee) {
}
