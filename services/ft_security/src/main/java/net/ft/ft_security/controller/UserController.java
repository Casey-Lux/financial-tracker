package net.ft.ft_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/info")
    public String getInfo(){
        return "user profile";
    }

    @PostMapping("/register")
    public String save(){
        return "user registered succesfully";
    }

    @PostMapping("/login")
    public String validate(){
        return "user logged in succesfully";
    }
}