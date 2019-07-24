package com.th.springcloudweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "customer")
public class UserController {
    @GetMapping(value = "user")
    public String user(){
        return "user";
    }

}
