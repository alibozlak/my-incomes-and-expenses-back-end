package dev.bozlak.incomesandexpenses.repositories.abstracts;

import dev.bozlak.incomesandexpenses.entities.concretes.IncomeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeGroupRepository extends JpaRepository<IncomeGroup,Integer> {
}
