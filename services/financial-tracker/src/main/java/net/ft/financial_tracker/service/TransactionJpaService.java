package net.ft.financial_tracker.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TransactionJpaService{
    private final TransanctionRepository repository;

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