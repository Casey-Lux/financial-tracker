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
import java.security.KeyPair;
import java.util.Base64;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/.well-known")
public class KeyController {
    private final KeyPair keyPair;

    @GetMapping("/public-key")
    public ResponseEntity<String> getPublicKey() {
        String encoded = Base64.getEncoder()
                .encodeToString(keyPair.getPublic().getEncoded());
        return ResponseEntity.ok(encoded);
    }
}
