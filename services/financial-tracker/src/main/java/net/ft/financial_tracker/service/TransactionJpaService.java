package net.ft.financial_tracker.service;

import lombok.AllArgsConstructor;
import net.ft.financial_tracker.model.Transaction;
import net.ft.financial_tracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TransactionJpaService{
    private final TransactionRepository repository;

    public Transaction save(Transaction transaction){
        return repository.save(transaction);
    }

    public Optional<Transaction> findAll(){
        return repository.findAll();
    }

    public Optional<Transaction> findByDescription(String description){
        return repository.findByDescription(description);
    }
}