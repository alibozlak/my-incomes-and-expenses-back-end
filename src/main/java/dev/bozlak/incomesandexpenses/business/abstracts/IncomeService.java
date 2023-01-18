package dev.bozlak.incomesandexpenses.business.abstracts;

import dev.bozlak.incomesandexpenses.dtos.concretes.Income.CreateIncomeRequest;
import dev.bozlak.incomesandexpenses.dtos.concretes.Income.IncomeGetAllColumnResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.Income.UpdateIncomeRequest;

public interface IncomeService extends
        EntityService<CreateIncomeRequest, UpdateIncomeRequest, Integer, IncomeGetAllColumnResponse> {
}
