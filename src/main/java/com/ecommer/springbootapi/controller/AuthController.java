package com.ecommer.springbootapi.controller;

import com.ecommer.springbootapi.dto.request.SignUpDto;
import com.ecommer.springbootapi.repository.UserRepository;
import com.ecommer.springbootapi.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRegisterService userRegisterService;
    private final UserRepository userRepository;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {
        if (userRepository.existsByUserName(signUpDto.getUsername())) {
            return new ResponseEntity<>("User name already exists", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }
        userRegisterService.register(signUpDto);
        return new ResponseEntity<>("User is register successfully ", HttpStatusCode.valueOf(201));
    }


    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody SignUpDto signUpDto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
