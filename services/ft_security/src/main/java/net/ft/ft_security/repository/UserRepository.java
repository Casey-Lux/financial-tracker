package net.ft.ft_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.ft.ft_security.model.User;

@Repository
public interface UserRepository exteds JpaRepository<User, Long>{
    void save(User user);
}