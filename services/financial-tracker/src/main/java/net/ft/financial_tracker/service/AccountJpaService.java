package net.ft.financial_tracker.service;

import lombok.AllArgsConstructor;
import net.ft.financial_tracker.model.Account;
import net.ft.financial_tracker.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountJpaService{
    private final AccountRepository repository;

    public Account save(Account account){
        return repository.save(account);
    }
}