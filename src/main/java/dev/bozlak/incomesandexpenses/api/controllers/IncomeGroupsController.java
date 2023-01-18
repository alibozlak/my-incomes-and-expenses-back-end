package dev.bozlak.incomesandexpenses.api.controllers;

import dev.bozlak.incomesandexpenses.business.abstracts.IncomeGroupService;
import dev.bozlak.incomesandexpenses.core.results.Result;
import dev.bozlak.incomesandexpenses.dtos.concretes.IncomeGroup.CreateIncomeGroupRequest;
import dev.bozlak.incomesandexpenses.dtos.concretes.IncomeGroup.IncomeGroupGetAllColumnResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.IncomeGroup.UpdateIncomeGroupRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/income-group")
public class IncomeGroupsController {
    private IncomeGroupService incomeGroupService;

    public IncomeGroupsController(IncomeGroupService incomeGroupService) {
        this.incomeGroupService = incomeGroupService;
    }

    @PostMapping
    public Result addIncomeGroup(@RequestBody CreateIncomeGroupRequest createIncomeGroupRequest){
        return this.incomeGroupService.add(createIncomeGroupRequest);
    }

    @PutMapping
    public Result updateIncomeGroup(@RequestBody UpdateIncomeGroupRequest updateIncomeGroupRequest){
        return this.incomeGroupService.update(updateIncomeGroupRequest);
    }

    @DeleteMapping(path = "/delete-by-id/{incomeGroupId}")
    public Result deleteById(@PathVariable int incomeGroupId){
        return this.incomeGroupService.deleteById(incomeGroupId);
    }

    @GetMapping(path = "/get-all")
    public List<IncomeGroupGetAllColumnResponse> getAllIncomeGroups(){
        return this.incomeGroupService.getAll();
    }

    @GetMapping(path = "/get-by-id/{incomeGroupId}")
    public IncomeGroupGetAllColumnResponse getIncomeGroupById(@PathVariable int incomeGroupId){
        return this.incomeGroupService.getById(incomeGroupId);
    }
}
