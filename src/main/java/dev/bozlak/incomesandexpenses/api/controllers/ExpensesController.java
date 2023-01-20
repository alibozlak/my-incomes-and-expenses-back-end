package dev.bozlak.incomesandexpenses.api.controllers;

import dev.bozlak.incomesandexpenses.business.abstracts.ExpenseService;
import dev.bozlak.incomesandexpenses.core.results.Result;
import dev.bozlak.incomesandexpenses.dtos.concretes.Expense.CreateExpenseRequest;
import dev.bozlak.incomesandexpenses.dtos.concretes.Expense.ExpenseGetAllColumnResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.Expense.UpdateExpenseRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/expense")
@CrossOrigin
public class ExpensesController {
    private ExpenseService expenseService;

    public ExpensesController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public Result addExpense(@RequestBody CreateExpenseRequest createExpenseRequest){
        return this.expenseService.add(createExpenseRequest);
    }

    @PutMapping
    public Result updateExpense(@RequestBody UpdateExpenseRequest updateExpenseRequest){
        return this.expenseService.update(updateExpenseRequest);
    }

    @DeleteMapping(path = "/delete-by-id/{expenseId}")
    public Result deleteExpenseById(@PathVariable int expenseId){
        return this.expenseService.deleteById(expenseId);
    }

    @GetMapping(path = "/get-all")
    public List<ExpenseGetAllColumnResponse> getAllExpenses(){
        return this.expenseService.getAll();
    }

    @GetMapping(path = "/get-by-id/{expenseId}")
    public ExpenseGetAllColumnResponse getExpenseById(@PathVariable int expenseId){
        return this.expenseService.getById(expenseId);
    }
}
