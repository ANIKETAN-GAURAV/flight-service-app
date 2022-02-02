package com.forerunners.backend.Dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "staffs")
public class Staffs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String pnr;

    @Column(name= "member_id", nullable = false)
    private String memberId;

    @Column(name = "password", nullable = false)
    private String password;

}
