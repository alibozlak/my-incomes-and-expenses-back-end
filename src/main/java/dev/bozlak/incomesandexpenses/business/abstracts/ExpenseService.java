package dev.bozlak.incomesandexpenses.business.abstracts;

import dev.bozlak.incomesandexpenses.dtos.concretes.Expense.CreateExpenseRequest;
import dev.bozlak.incomesandexpenses.dtos.concretes.Expense.ExpenseGetAllColumnResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.Expense.UpdateExpenseRequest;

public interface ExpenseService extends
        EntityService<CreateExpenseRequest,UpdateExpenseRequest,Integer, ExpenseGetAllColumnResponse>{
}
