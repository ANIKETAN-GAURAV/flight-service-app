package com.forerunners.backend.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StaffObj {
    private String pnr;
    private String memberId;
    private String password;
}
