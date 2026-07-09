package net.ft.ft_security.service;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.AllArgsConstructor;
import net.ft.ft_security.model.User;
import net.ft.ft_security.model.Role;
import net.ft.ft_security.repository.UserRepository;
import net.ft.ft_security.repository.RoleRepository;
import java.util.Optional;
import java.util.List;

@AllArgsConstructor
@Service
public class AuthService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(String email, String username, String password){
        Role role = roleRepository.findById(3L).
            orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoleList(List.of(role));
        return userRepository.save(user);
    }
}
