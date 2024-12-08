package com.example.nto.controller;


import com.example.nto.entity.Employee;
import com.example.nto.service.impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeServiceImpl service;


    @GetMapping("{login}/auth")
    private ResponseEntity<String> getAuth(@PathVariable("login") String login){

        Employee employee = service.findEmployeeByLogin(login);
        if(employee!=null){
            return ResponseEntity.status(200).body("данный логин существует - можно пользоваться приложением");

        }
        else{
            return ResponseEntity.status(401).body("логина не существует или неверный");
        }



    }

    @GetMapping("{login}/info")
    private ResponseEntity<Object> getInfo(@PathVariable("login") String login){
        Employee employee = service.findEmployeeByLogin(login);
        if(employee!=null){
            return ResponseEntity.ok(employee);


        }
        else{
            return ResponseEntity.status(401).body("логина не существует или неверный");
        }

    }

    @PatchMapping("{login}/open")
    private ResponseEntity<Object> updateLocalTime(@PathVariable("login") String login){
        Employee employee = service.findEmployeeByLogin(login);
        if(employee!=null){
            employee.setLastVisit(LocalDateTime.now());
            service.updateLocalTime(employee);

            return ResponseEntity.status(200).body("дверь открылась");
        }
        else {
            return ResponseEntity.status(401).body("логина не существует или неверный");
        }
    }


}
