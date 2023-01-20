package dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup;

import dev.bozlak.incomesandexpenses.core.Dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExpenseGroupIdAndNameResponse implements Dto {
    private int expenseGroupId;
    private String expenseGroupName;
}
