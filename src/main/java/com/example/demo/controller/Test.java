package com.example.demo.controller;

import com.example.demo.service.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
//@RequestMapping("/")
public class Test {

    @Autowired
    BCrypt bCrypt;

    @GetMapping(value = "/login")
    public String authorize() {

        String bCrupt = getHashedPassword("Mark6978");
        bCrypt.set(bCrupt);
        return bCrupt;
    }

    private String getHashedPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
