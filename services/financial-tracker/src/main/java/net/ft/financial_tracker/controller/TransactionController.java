package net.ft.financial_tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.ft.financial_tracker.service.TransactionJpaService;

@RestController
@RequestMapping("/api/v1/transactions")
public class transactionController{
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