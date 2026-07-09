package net.ft.ft_security.service;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import net.ft.ft_security.model.Role;
import net.ft.ft_security.repository.RoleRepository;

@AllArgsConstructor
@Service
public class RoleService{
    private final RoleRepository repository;

    public Optional<Role> save(Role role){
        return repository.save(role);
    }
}