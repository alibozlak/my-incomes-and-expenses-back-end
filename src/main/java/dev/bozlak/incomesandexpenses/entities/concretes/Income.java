package dev.bozlak.incomesandexpenses.entities.concretes;

import dev.bozlak.incomesandexpenses.core.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@javax.persistence.Entity
@Table(name = "incomes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Income implements Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "income_id")
    private int incomeId;

    @Column(name = "income_group_id", nullable = false)
    private int incomeGroupId;

    @Column(name = "income_amount", nullable = false)
    private double incomeAmount;

    @Column(nullable = false)
    private LocalDate date;

    private String description;
}
