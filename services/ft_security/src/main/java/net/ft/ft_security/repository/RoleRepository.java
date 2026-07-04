package net.ft.ft_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.ft.ft_security.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role save(Role role);

    Role findById(Long id);
}