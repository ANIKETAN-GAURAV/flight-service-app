package com.forerunners.backend.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserObj {
    private String pnr;
    private String userName;
    private String seatNo;
    private String password;
}
