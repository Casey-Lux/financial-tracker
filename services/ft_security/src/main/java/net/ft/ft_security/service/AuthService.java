package net.ft.ft_security.service;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import net.ft.ft_security.model.User;
import net.ft.ft_security.model.Role;
import net.ft.ft_security.repository.UserRepository;
import net.ft.ft_security.repository.RoleRepository;

@AllArgsConstructor
@Service
public class AuthService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public void register(String email, String username, String password){
        Role role = new Role();
        role = roleRepository.findById(1L);
        User user = new User(email, username, password, true, role);
        userRepository.save(email, username, password, true, RoleEnum.DEMO)
    }
}