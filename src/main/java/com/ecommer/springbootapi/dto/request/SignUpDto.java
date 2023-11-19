package com.ecommer.springbootapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignUpDto {
    private String fullName;
    private String username;
    private String email;
    private String password;

}
