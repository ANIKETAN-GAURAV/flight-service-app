package com.forerunners.backend.Dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String pnr;

    @Column( nullable = false, length = 64)
    private String password;

    @Column(name= "user_name", nullable = false, length = 20)
    private String userName;

    @Column(name= "health_info")
    private String healthInfo;

    @Column(name= "food_items")
    private String foodItems;

    @Column(name = "query")
    private String query;

    @Column(name= "any_order")
    private Integer anyOrder;

    @Column(name= "created_time")
    private Date createdTime;

    @Column(name = "seat_no")
    private String seatNo;
}
