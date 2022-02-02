package com.forerunner.backend.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = false)
@ToString
public class UserObj {
    private String pnr;
    private String userName;
    private String seatNo;
    private String password;
}
