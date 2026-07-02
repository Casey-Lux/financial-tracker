package net.ft.financial_tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.AllArgsConstructor;
import net.ft.financial_tracker.service.TransactionJpaService;
import net.ft.financial_tracker.model.Transaction;
import java.util.List;
import java.util.Optional;
import java.time.LocalTime;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController{
    final TransactionJpaService service;

    @GetMapping("/{acc_id}")
    public List<Transaction> history(
            @PathVariable Long acc_id,
            @RequestParam(required = false) LocalDate start,
            @RequestParam(required = false) LocalDate end ){
        return service.findByAccount(acc_id, start, end);
    }

    @PostMapping()
    public Transaction save(@RequestBody Transaction transaction){
        return service.save(transaction);
    }

}