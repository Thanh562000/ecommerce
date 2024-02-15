package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.dto.request.SignUpDto;
import com.ecommer.springbootapi.entities.User;
import com.ecommer.springbootapi.repository.RoleRepository;
import com.ecommer.springbootapi.repository.UserRepository;
import com.ecommer.springbootapi.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegisterServiceImpl implements UserRegisterService {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public SignUpDto register(SignUpDto signUpDto) {
        User user = mapToEntity(signUpDto);
        User registerUser = userRepository.save(user);
        return mapToDto(registerUser);
    }

    private SignUpDto mapToDto(User user) {
        return modelMapper.map(user, SignUpDto.class);
    }

    private User mapToEntity(SignUpDto signUpDto) {
        User user = new User();
        user.setFullName(signUpDto.getFullName());
        user.setUserName(signUpDto.getUsername());
        user.setPassword(signUpDto.getPassword());
        user.setEmail(signUpDto.getEmail());

//        Role role = roleRepository.findByName("ROLE_USER").get();
//        user.setRoles(Collections.singleton(role));
        return user;
    }
}
