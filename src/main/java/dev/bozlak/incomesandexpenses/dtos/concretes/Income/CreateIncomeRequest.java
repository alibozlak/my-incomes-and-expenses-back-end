package dev.bozlak.incomesandexpenses.dtos.concretes.Income;

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
public class CreateIncomeRequest implements Dto {
    private int incomeGroupId;
    private double incomeAmount;
    private LocalDate date;
    private String description;
}
