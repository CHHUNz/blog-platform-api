package com.kosign.dev.payload.employee;


public record EmployeeRequest(
        String fullName,
        String email,
        String role
) {
}
