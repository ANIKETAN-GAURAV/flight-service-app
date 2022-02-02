package com.forerunner.backend.Dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "staffs",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String pnr;

    @Column(name= "member_id", nullable = false, length = 45)
    private String crewMember_id;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

}
