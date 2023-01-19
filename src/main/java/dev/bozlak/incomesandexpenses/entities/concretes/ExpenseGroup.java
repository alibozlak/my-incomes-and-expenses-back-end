package dev.bozlak.incomesandexpenses.entities.concretes;

import dev.bozlak.incomesandexpenses.core.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "expense_groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseGroup implements Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_group_id")
    private int expenseGroupId;

    @Column(name = "expense_group_name", nullable = false, unique = true)
    private String expenseGroupName;

    private String description;
}
