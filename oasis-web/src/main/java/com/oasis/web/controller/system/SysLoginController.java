package com.oasis.web.controller.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/login")
public class SysLoginController {
    @RequestMapping
    public String login(){
        return "login";
    }
}
