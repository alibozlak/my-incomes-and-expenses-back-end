package dev.bozlak.incomesandexpenses.repositories.abstracts;

import dev.bozlak.incomesandexpenses.entities.concretes.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
}
