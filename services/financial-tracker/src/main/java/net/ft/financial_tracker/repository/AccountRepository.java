package net.ft.financial_tracker.repository;

import net.ft.financial_tracker.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Account, Long>{
    Optional<Account> findById(Long id);
    Account save(Account account);
    Optional<Account> findByDescription(String description);
}