package net.ft.financial_tracker.model;

import net.ft.financial_tracker.enum.Type;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ft_transaction")
public class Transaction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = true, length = 120)
    private String description;

    @Column(nullable = true)
    private int importance;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.String)
    @Column(nullable = false)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}