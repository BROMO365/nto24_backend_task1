package com.example.nto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Employee {
    @Id
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name="name")
    private String name;

    @Column(name = "photo")
    private String photo;

    @Column(name="position")
    private String position;

    @Column(name="lastVisit")
    private LocalDateTime lastVisit;
}
