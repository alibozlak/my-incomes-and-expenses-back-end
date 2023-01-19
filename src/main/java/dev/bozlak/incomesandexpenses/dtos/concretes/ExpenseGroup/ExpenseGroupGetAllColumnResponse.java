package dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup;

import dev.bozlak.incomesandexpenses.core.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseGroupGetAllColumnResponse implements Dto {
    private int expenseGroupId;
    private String expenseGroupName;
    private String description;
}
