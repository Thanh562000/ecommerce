package com.ecommer.springbootapi.controller;

import com.ecommer.springbootapi.service.FagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FaqController {
    private final FagService fagService;
}
