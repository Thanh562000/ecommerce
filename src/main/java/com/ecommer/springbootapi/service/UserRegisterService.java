package com.ecommer.springbootapi.service;

import com.ecommer.springbootapi.dto.request.SignUpDto;

public interface UserRegisterService {
    SignUpDto register(SignUpDto signUpDto);
}
