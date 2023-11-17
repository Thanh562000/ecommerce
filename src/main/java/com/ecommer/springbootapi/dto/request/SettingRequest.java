package com.ecommer.springbootapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettingRequest {
    private Long id;
    private String title;
    private String keywords;
    private String description;
    private String company;
    private String address;
    private String phone;
    private String fax;
    private String email;
    private String smtpServer;
    private String smtpEmail;
    private String smtpPassword;
    private String smtpPort;
    private String facebook;
    private String instagram;
    private String twitter;
    private String aboutUs;
    private String contact;
    private String reference;
    private String status;
}
