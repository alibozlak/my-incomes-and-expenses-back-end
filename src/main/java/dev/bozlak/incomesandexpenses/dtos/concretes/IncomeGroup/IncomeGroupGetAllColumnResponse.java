package dev.bozlak.incomesandexpenses.dtos.concretes.IncomeGroup;

import dev.bozlak.incomesandexpenses.core.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeGroupGetAllColumnResponse implements Dto {
    private int incomeGroupId;
    private String incomeGroupName;
    private String description;
}
