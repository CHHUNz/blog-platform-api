package com.kosign.dev.controller;

import com.kosign.dev.payload.employee.EmployeeRequest;
import com.kosign.dev.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController extends AbstractRestController {
    private final EmployeeService employeeService;

    @PostMapping("/create")
    public Object insertEmployee(@RequestBody EmployeeRequest payload){
        employeeService.insertEmployee(payload);
        return ok();
    }
    @GetMapping("")
    public Object getAllEmployees(){
        return ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public Object getEmployeeById(@PathVariable("id") Long id){
        return ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/update/{id}")
    public Object updateEmployee(@RequestBody EmployeeRequest employeeRequest, @PathVariable("id") Long id){
        employeeService.updateEmployee(employeeRequest, id);
        return ok();
    }
    @DeleteMapping("/delete/{id}")
    public Object deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ok();
    }
}
