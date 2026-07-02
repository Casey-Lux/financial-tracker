package net.ft.financial_tracker.repository;

import net.ft.financial_tracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    Optional<Transaction> findById(Long id);

    Optional<Transaction> findByDescription(String description);

    List<Transaction> findByAccount(Long acc_id);
}