package net.ft.ft_security.controller;

import com.security.auth.dto.AuthRequest;
import com.security.auth.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @GetMapping("/info")
    public String getInfo(){
        return "user profile";
    }

    @PostMapping("/register")
    public String save(){
        return "user registered succesfully";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthentionToken(request.getUsername(), request.getPassword())
        );
(BadCredentialsException)
        String token = jwtService.generateToken(request.getUsername());
        return ResponseEntity.ok(token);
    }
}