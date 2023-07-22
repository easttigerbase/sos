package com.ssoptimus.sos.controller.Security;

import com.ssoptimus.sos.auth.filters.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public LoginController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @RequestMapping(value = "/login")
    public String doLogin(){

        return jwtTokenProvider.createToken("asdd22");
    }
}
