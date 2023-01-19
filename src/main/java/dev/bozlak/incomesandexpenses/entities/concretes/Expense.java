package dev.bozlak.incomesandexpenses.entities.concretes;

import dev.bozlak.incomesandexpenses.core.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@javax.persistence.Entity
@Table(name = "expenses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense implements Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private int expenseId;

    @Column(name = "expense_group_id", nullable = false)
    private int expenseGroupId;

    @Column(name = "expense_amount", nullable = false)
    private double expenseAmount;

    @Column(nullable = false)
    private LocalDate date;

    private String description;
}
