package net.ft.financial_tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import net.ft.financial_tracker.service.AccountJpaService;
import net.ft.financial_tracker.model.Account;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController{
    final AccountJpaService service;

    @PostMapping("/new")
    public Account save(@RequestBody Account account){
        return service.save(account);
    }
}