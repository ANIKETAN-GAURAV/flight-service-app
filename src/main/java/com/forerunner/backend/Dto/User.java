package com.forerunner.backend.Dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String pnr;

    @Column( nullable = false, length = 64)
    private String password;

    @Column(name= "user_name", nullable = false, length = 20)
    private String userName;

    @Column(name= "healthInfo")
    private String healthInfo;

    @Column(name= "foodItems")
    private String foodItems;

    @Column(name= "anyOrder")
    private Boolean anyOrder;

    @Column(name= "createdTime")
    private Date createdTime;
}
