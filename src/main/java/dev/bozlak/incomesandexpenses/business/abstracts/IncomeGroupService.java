package dev.bozlak.incomesandexpenses.business.abstracts;

import dev.bozlak.incomesandexpenses.dtos.concretes.IncomeGroup.CreateIncomeGroupRequest;
import dev.bozlak.incomesandexpenses.dtos.concretes.IncomeGroup.IncomeGroupGetAllColumnResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.IncomeGroup.UpdateIncomeGroupRequest;

public interface IncomeGroupService
        extends EntityService<CreateIncomeGroupRequest,UpdateIncomeGroupRequest,Integer, IncomeGroupGetAllColumnResponse>{
}
