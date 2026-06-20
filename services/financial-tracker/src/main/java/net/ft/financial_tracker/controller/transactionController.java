package net.ft.financial_tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class transactionController{

    @GetMapping("/history")
    public String history(){
        return "this is the history";
    }

}