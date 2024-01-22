package com.kosign.dev.service.employee;

import com.kosign.dev.domain.employee.EmployeeRepository;
import com.kosign.dev.exception.CusNotFoundException;
import com.kosign.dev.payload.employee.EmployeeMainRes;
import com.kosign.dev.payload.employee.EmployeeRequest;
import com.kosign.dev.payload.employee.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    @Override
    public void insertEmployee(EmployeeRequest payload) {
        var entity = employeeMapper.mapToEntity(payload);
        employeeRepository.save(entity);
    }

    @Override
    public Object getAllEmployees() {
        var employeeList = employeeRepository.findAllEmployee();
        // ====== this code can work too =========
//        return employeeList.stream()
//                .map(employeeMapper::mapToResponse)
//                .collect(Collectors.toList());
        // =======================================
        List<EmployeeResponse> employeeResponses = employeeList.stream()
                .map(employeeMapper::mapToResponse)
                .collect(Collectors.toList());
        return new EmployeeMainRes(employeeResponses);
    }

    @Override
    public Object getEmployeeById(Long id) {
        // ======= this code is work too ( short form ) =======
//        return employeeRepository.findById(id)
//                .map(employeeMapper::mapToResponse)
//                .orElseThrow(()-> new CusNotFoundException("Employee is not found"));
        // =====================================
        EmployeeResponse response = employeeRepository.findEmployeeById(id)
                .map(employeeMapper::mapToResponse)
                .orElseThrow(()-> new CusNotFoundException("Employee is not found"));
        return response;
    }

    @Override
    public void updateEmployee(EmployeeRequest payload, Long id) {
       var employee = employeeRepository.findEmployeeById(id)
                        .orElseThrow(()-> new CusNotFoundException("Employee is not found"));
        employee.setFullName(payload.fullName());
        employee.setEmail(payload.email());
        employee.setRole(payload.role());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        var employee = employeeRepository.findById(id)
                .orElseThrow(()-> new CusNotFoundException("Employee is not found"));
        employeeRepository.deleteById(employee.getId());
    }
}
