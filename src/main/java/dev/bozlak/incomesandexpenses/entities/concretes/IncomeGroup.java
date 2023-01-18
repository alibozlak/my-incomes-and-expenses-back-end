package dev.bozlak.incomesandexpenses.entities.concretes;

import dev.bozlak.incomesandexpenses.core.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "income_groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeGroup implements Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "income_group_id")
    private int incomeGroupId;

    @Column(name = "income_group_name", nullable = false, unique = true)
    private String incomeGroupName;

    private String description;
}
