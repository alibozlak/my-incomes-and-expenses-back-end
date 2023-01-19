package dev.bozlak.incomesandexpenses.repositories.abstracts;

import dev.bozlak.incomesandexpenses.entities.concretes.ExpenseGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseGroupRepository extends JpaRepository<ExpenseGroup,Integer> {
}
