package com.ssoptimus.sos.controller.Security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/auth")
public class AuthController {


    @RequestMapping(value = "/authenticate")
    public void  authenticate(){

    }

    @RequestMapping(value = "/validate")
    public void Validating(){

    }
}

