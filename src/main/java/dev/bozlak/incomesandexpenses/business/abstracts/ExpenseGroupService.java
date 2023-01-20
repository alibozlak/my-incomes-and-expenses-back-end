package dev.bozlak.incomesandexpenses.business.abstracts;

import dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup.CreateExpenseGroupRequest;
import dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup.ExpenseGroupGetAllColumnResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup.ExpenseGroupIdAndNameResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup.UpdateExpenseGroupRequest;

import java.util.List;

public interface ExpenseGroupService extends
    EntityService<CreateExpenseGroupRequest, UpdateExpenseGroupRequest, Integer, ExpenseGroupGetAllColumnResponse> {

    List<ExpenseGroupIdAndNameResponse> getAllExpenseGroupIdAndNameResponses();
}
