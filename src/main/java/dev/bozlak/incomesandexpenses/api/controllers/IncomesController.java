package dev.bozlak.incomesandexpenses.api.controllers;

import dev.bozlak.incomesandexpenses.business.abstracts.IncomeService;
import dev.bozlak.incomesandexpenses.core.results.Result;
import dev.bozlak.incomesandexpenses.dtos.concretes.Income.CreateIncomeRequest;
import dev.bozlak.incomesandexpenses.dtos.concretes.Income.IncomeGetAllColumnResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.Income.UpdateIncomeRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/income")
@CrossOrigin
public class IncomesController {
    private IncomeService incomeService;

    public IncomesController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping
    public Result addIncome(@RequestBody CreateIncomeRequest createIncomeRequest){
        return this.incomeService.add(createIncomeRequest);
    }

    @PutMapping
    public Result updateIncome(@RequestBody UpdateIncomeRequest updateIncomeRequest){
        return this.incomeService.update(updateIncomeRequest);
    }

    @DeleteMapping(path = "/delete-by-id/{incomeId}")
    public Result deleteIncomeById(@PathVariable int incomeId){
        return this.incomeService.deleteById(incomeId);
    }

    @GetMapping(path = "/get-all")
    public List<IncomeGetAllColumnResponse> getAllIncomes(){
        return this.incomeService.getAll();
    }

    @GetMapping("/get-by-id/{incomeId}")
    public IncomeGetAllColumnResponse getIncomeById(@PathVariable int incomeId){
        return this.incomeService.getById(incomeId);
    }
}
