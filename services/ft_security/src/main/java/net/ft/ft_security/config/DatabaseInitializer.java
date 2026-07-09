package net.ft.ft_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import lombok.RequiredArgsConstructor;
import net.ft.ft_security.service.RoleService;
import net.ft.ft_security.model.Role;
import net.ft.ft_security.enums.RoleEnum;

@Configuration
@RequiredArgsConstructor
public class DatabaseInitializer {

    private final RoleService roleService;

    @Bean
    CommandLineRunner init() {
        return args -> {
            for (RoleEnum roleEnum : RoleEnum.values()) {
                Role role = new Role();
                role.setName(roleEnum);
                roleService.save(role);
            }
        };
    }
}
