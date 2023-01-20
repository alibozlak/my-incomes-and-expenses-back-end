package dev.bozlak.incomesandexpenses.api.controllers;

import dev.bozlak.incomesandexpenses.business.abstracts.ExpenseGroupService;
import dev.bozlak.incomesandexpenses.core.results.Result;
import dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup.CreateExpenseGroupRequest;
import dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup.ExpenseGroupGetAllColumnResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup.ExpenseGroupIdAndNameResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup.UpdateExpenseGroupRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/expense-group")
@CrossOrigin
public class ExpenseGroupsController {
    private ExpenseGroupService expenseGroupService;

    public ExpenseGroupsController(ExpenseGroupService expenseGroupService) {
        this.expenseGroupService = expenseGroupService;
    }

    @PostMapping
    public Result addExpenseGroup(@RequestBody CreateExpenseGroupRequest createExpenseGroupRequest){
        return this.expenseGroupService.add(createExpenseGroupRequest);
    }

    @PutMapping
    public Result updateExpenseGroup(@RequestBody UpdateExpenseGroupRequest updateExpenseGroupRequest){
        return this.expenseGroupService.update(updateExpenseGroupRequest);
    }

    @DeleteMapping(path = "/delete-by-id/{expenseGroupId}")
    public Result deleteExpenseGroupById(@PathVariable int expenseGroupId){
        return this.expenseGroupService.deleteById(expenseGroupId);
    }

    @GetMapping(path = "/get-all")
    public List<ExpenseGroupGetAllColumnResponse> getAllExpenseGroups(){
        return this.expenseGroupService.getAll();
    }

    @GetMapping(path = "/get-by-id/{expenseGroupId}")
    public ExpenseGroupGetAllColumnResponse getExpenseGroupById(@PathVariable int expenseGroupId){
        return this.expenseGroupService.getById(expenseGroupId);
    }

    @GetMapping(path = "/get-all-id-and-names")
    public List<ExpenseGroupIdAndNameResponse> getAllIdAndNames(){
        return this.expenseGroupService.getAllExpenseGroupIdAndNameResponses();
    }
}
