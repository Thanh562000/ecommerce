package com.ecommer.springbootapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;
    private String ipAddress;
    private String status;
}
