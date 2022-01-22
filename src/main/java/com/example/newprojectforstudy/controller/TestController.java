package com.example.newprojectforstudy.controller;

import com.example.newprojectforstudy.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;


}
