package com.forerunner.backend.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = false)
@ToString
public class StaffObj {
    private String pnr;
    private String member_id;
    private String password;
}
