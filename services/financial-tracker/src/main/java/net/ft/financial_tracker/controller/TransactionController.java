package net.ft.financial_tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import net.ft.financial_tracker.service.TransactionJpaService;
import net.ft.financial_tracker.model.Transaction;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController{
    final TransactionJpaService service;

    @GetMapping()
    public List<Transaction> history(){
        return service.findAll();
    }

    @PostMapping()
    public Transaction save(Transaction transaction){
        return service.save(transaction);
    }

}