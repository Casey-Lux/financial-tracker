package net.ft.financial_tracker.service;

import lombok.AllArgsConstructor;
import net.ft.financial_tracker.model.Category;
import net.ft.financial_tracker.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryJpaService{
    private final CategoryRepository repository;

    public Category save(Category category){
        return repository.save(category);
    }
}