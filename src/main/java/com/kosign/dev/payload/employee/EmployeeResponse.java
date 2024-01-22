package com.kosign.dev.payload.employee;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String fullName;
    private String email;
    private String role;
    public EmployeeResponse(Long id, String fullName, String email, String role){
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }

}
