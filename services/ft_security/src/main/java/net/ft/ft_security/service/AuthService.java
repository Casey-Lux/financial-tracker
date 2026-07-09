package net.ft.ft_security.service;

import org.springframework.stereotype.Service;
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

    public User register(String email, String username, String password){
        Role role = roleRepository.findById(1L).
            orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setRoleList(List.of(role));
        return userRepository.save(user);
    }
}
