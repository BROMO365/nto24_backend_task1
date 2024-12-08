package com.example.nto.service;

import com.example.nto.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    public void updateLocalTime(Employee employee);
    public Employee findEmployeeByLogin(String login);
}
