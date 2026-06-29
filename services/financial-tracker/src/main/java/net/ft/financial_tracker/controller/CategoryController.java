package net.ft.financial_tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import net.ft.financial_tracker.service.CategoryJpaService;
import net.ft.financial_tracker.model.Category;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController{
    final CategoryJpaService service;

    @PostMapping("/new")
    public Category save(@RequestBody Category category){
        return service.save(category);
    }
}