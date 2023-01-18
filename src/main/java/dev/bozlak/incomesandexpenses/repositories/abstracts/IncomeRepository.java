package dev.bozlak.incomesandexpenses.repositories.abstracts;

import dev.bozlak.incomesandexpenses.entities.concretes.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income,Integer> {
}
