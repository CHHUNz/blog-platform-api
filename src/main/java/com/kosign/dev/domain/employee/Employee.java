package com.kosign.dev.domain.employee;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private String role;

    @Builder
    public Employee(String fullName, String email, String role) {
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }
}
