package com.kosign.dev.domain.employee;

import com.kosign.dev.payload.employee.EmployeeRequest;
import com.kosign.dev.payload.employee.EmployeeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e from Employee e where e.id = ?1")
    Optional<Employee> findEmployeeById(Long id);

    @Query("select e from Employee e order by e.id asc ")
    List<Employee> findAllEmployee();



}
