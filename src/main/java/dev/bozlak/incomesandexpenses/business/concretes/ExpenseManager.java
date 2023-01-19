package dev.bozlak.incomesandexpenses.business.concretes;

import dev.bozlak.incomesandexpenses.business.abstracts.ExpenseService;
import dev.bozlak.incomesandexpenses.core.results.ErrorResult;
import dev.bozlak.incomesandexpenses.core.results.Result;
import dev.bozlak.incomesandexpenses.core.results.SuccessResult;
import dev.bozlak.incomesandexpenses.dtos.concretes.Expense.CreateExpenseRequest;
import dev.bozlak.incomesandexpenses.dtos.concretes.Expense.ExpenseGetAllColumnResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.Expense.UpdateExpenseRequest;
import dev.bozlak.incomesandexpenses.entities.concretes.Expense;
import dev.bozlak.incomesandexpenses.repositories.abstracts.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseManager implements ExpenseService {
    private ExpenseRepository expenseRepository;

    public ExpenseManager(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Result add(CreateExpenseRequest createEntityDto) {
        Expense expense = new Expense();
        expense.setExpenseGroupId(createEntityDto.getExpenseGroupId());
        expense.setExpenseAmount(createEntityDto.getExpenseAmount());
        expense.setDate(createEntityDto.getDate());
        expense.setDescription(createEntityDto.getDescription());
        Expense returnedExpense = this.expenseRepository.save(expense);
        if (returnedExpense != null)
            return new SuccessResult();
        return new ErrorResult();
    }

    @Override
    public Result update(UpdateExpenseRequest updateEntityDto) {
        Expense expense = new Expense();
        expense.setExpenseId(updateEntityDto.getExpenseId());
        expense.setExpenseGroupId(updateEntityDto.getExpenseGroupId());
        expense.setExpenseAmount(updateEntityDto.getExpenseAmount());
        expense.setDate(updateEntityDto.getDate());
        expense.setDescription(updateEntityDto.getDescription());
        Expense returnedExpense = this.expenseRepository.save(expense);
        if (returnedExpense != null)
            return new SuccessResult();
        return new ErrorResult();
    }

    @Override
    public Result deleteById(Integer id) {
        this.expenseRepository.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public List<ExpenseGetAllColumnResponse> getAll() {
        List<Expense> expenses = this.expenseRepository.findAll();
        List<ExpenseGetAllColumnResponse> expenseGetAllColumnResponses = new ArrayList<>();
        expenses.forEach(expense -> {
            ExpenseGetAllColumnResponse expenseGetAllColumnResponse = new ExpenseGetAllColumnResponse();
            expenseGetAllColumnResponse.setExpenseId(expense.getExpenseId());
            expenseGetAllColumnResponse.setExpenseGroupId(expense.getExpenseGroupId());
            expenseGetAllColumnResponse.setExpenseAmount(expense.getExpenseAmount());
            expenseGetAllColumnResponse.setDate(expense.getDate());
            expenseGetAllColumnResponse.setDescription(expense.getDescription());
            expenseGetAllColumnResponses.add(expenseGetAllColumnResponse);
        });
        return expenseGetAllColumnResponses;
    }

    @Override
    public ExpenseGetAllColumnResponse getById(Integer id) {
        Expense expense = this.expenseRepository.getReferenceById(id);
        ExpenseGetAllColumnResponse expenseGetAllColumnResponse = new ExpenseGetAllColumnResponse();
        expenseGetAllColumnResponse.setExpenseId(expense.getExpenseId());
        expenseGetAllColumnResponse.setExpenseGroupId(expense.getExpenseGroupId());
        expenseGetAllColumnResponse.setExpenseAmount(expense.getExpenseAmount());
        expenseGetAllColumnResponse.setDate(expense.getDate());
        expenseGetAllColumnResponse.setDescription(expense.getDescription());
        return expenseGetAllColumnResponse;
    }
}
