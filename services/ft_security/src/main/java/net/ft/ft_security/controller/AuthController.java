package net.ft.ft_security.controller;

import net.ft.ft_security.dto.AuthRequest;
import net.ft.ft_security.dto.RegisterRequest;
import net.ft.ft_security.model.User;
import net.ft.ft_security.service.JwtService;
import net.ft.ft_security.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AuthService authService;

    @GetMapping("/info")
    public String getInfo(){
        return "user profile";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
            User user = authService.register(request.getEmail(), request.getUsername(), request.getPassword());
            String token = jwtService.generateToken(String.valueOf(user.getId()));
            return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        String token = jwtService.generateToken(request.getUsername());
        return ResponseEntity.ok(token);
    }
}
