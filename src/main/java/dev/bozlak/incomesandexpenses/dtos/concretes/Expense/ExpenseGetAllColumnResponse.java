package dev.bozlak.incomesandexpenses.dtos.concretes.Expense;

import dev.bozlak.incomesandexpenses.core.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseGetAllColumnResponse implements Dto {
    private int expenseId;
    private int expenseGroupId;
    private double expenseAmount;
    private LocalDate date;
    private String description;
}
