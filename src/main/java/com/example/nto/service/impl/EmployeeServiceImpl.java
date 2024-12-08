package com.example.nto.service.impl;

import com.example.nto.entity.Employee;
import com.example.nto.repository.EmployeeRepository;
import com.example.nto.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;
    @Override
    public void updateLocalTime(Employee employee) {
        employee.setLastVisit(LocalDateTime.now());
        repository.save(employee);
    }

    @Override
    public Employee findEmployeeByLogin(String login) {

        return repository.findEmployeeByLogin(login);
    }
}
