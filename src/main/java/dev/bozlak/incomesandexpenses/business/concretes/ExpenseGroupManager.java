package dev.bozlak.incomesandexpenses.business.concretes;

import dev.bozlak.incomesandexpenses.business.abstracts.ExpenseGroupService;
import dev.bozlak.incomesandexpenses.core.results.ErrorResult;
import dev.bozlak.incomesandexpenses.core.results.Result;
import dev.bozlak.incomesandexpenses.core.results.SuccessResult;
import dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup.CreateExpenseGroupRequest;
import dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup.ExpenseGroupGetAllColumnResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup.ExpenseGroupIdAndNameResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.ExpenseGroup.UpdateExpenseGroupRequest;
import dev.bozlak.incomesandexpenses.entities.concretes.ExpenseGroup;
import dev.bozlak.incomesandexpenses.repositories.abstracts.ExpenseGroupRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseGroupManager implements ExpenseGroupService {
    private ExpenseGroupRepository expenseGroupRepository;

    public ExpenseGroupManager(ExpenseGroupRepository expenseGroupRepository) {
        this.expenseGroupRepository = expenseGroupRepository;
    }

    @Override
    public Result add(CreateExpenseGroupRequest createEntityDto) {
        ExpenseGroup expenseGroup = new ExpenseGroup();
        expenseGroup.setExpenseGroupName(createEntityDto.getExpenseGroupName());
        expenseGroup.setDescription(createEntityDto.getDescription());
        ExpenseGroup returnedExpenseGroup = this.expenseGroupRepository.save(expenseGroup);
        if (returnedExpenseGroup != null)
            return new SuccessResult();
        return new ErrorResult();
    }

    @Override
    public Result update(UpdateExpenseGroupRequest updateEntityDto) {
        ExpenseGroup expenseGroup = new ExpenseGroup();
        expenseGroup.setExpenseGroupId(updateEntityDto.getExpenseGroupId());
        expenseGroup.setExpenseGroupName(updateEntityDto.getExpenseGroupName());
        expenseGroup.setDescription(updateEntityDto.getDescription());
        ExpenseGroup returnedExpenseGroup = this.expenseGroupRepository.save(expenseGroup);
        if (returnedExpenseGroup != null)
            return new SuccessResult();
        return new ErrorResult();
    }

    @Override
    public Result deleteById(Integer id) {
        this.expenseGroupRepository.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public List<ExpenseGroupGetAllColumnResponse> getAll() {
        List<ExpenseGroup> expenseGroups = this.expenseGroupRepository.findAll();
        List<ExpenseGroupGetAllColumnResponse> expenseGroupGetAllColumnResponses = new ArrayList<>();
        expenseGroups.forEach(expenseGroup -> {
            ExpenseGroupGetAllColumnResponse expenseGroupGetAllColumnResponse = new ExpenseGroupGetAllColumnResponse();
            expenseGroupGetAllColumnResponse.setExpenseGroupId(expenseGroup.getExpenseGroupId());
            expenseGroupGetAllColumnResponse.setExpenseGroupName(expenseGroup.getExpenseGroupName());
            expenseGroupGetAllColumnResponse.setDescription(expenseGroup.getDescription());
            expenseGroupGetAllColumnResponses.add(expenseGroupGetAllColumnResponse);
        });
        return expenseGroupGetAllColumnResponses;
    }

    @Override
    public ExpenseGroupGetAllColumnResponse getById(Integer id) {
        ExpenseGroup expenseGroup = this.expenseGroupRepository.getReferenceById(id);
        ExpenseGroupGetAllColumnResponse expenseGroupGetAllColumnResponse = new ExpenseGroupGetAllColumnResponse();
        expenseGroupGetAllColumnResponse.setExpenseGroupId(expenseGroup.getExpenseGroupId());
        expenseGroupGetAllColumnResponse.setExpenseGroupName(expenseGroup.getExpenseGroupName());
        expenseGroupGetAllColumnResponse.setDescription(expenseGroup.getDescription());
        return expenseGroupGetAllColumnResponse;
    }

    @Override
    public List<ExpenseGroupIdAndNameResponse> getAllExpenseGroupIdAndNameResponses() {
        List<ExpenseGroup> expenseGroups = this.expenseGroupRepository.findAll();
        List<ExpenseGroupIdAndNameResponse> expenseGroupIdAndNameResponses = new ArrayList<>();
        expenseGroups.forEach(expenseGroup -> {
            ExpenseGroupIdAndNameResponse expenseGroupIdAndNameResponse = new ExpenseGroupIdAndNameResponse();
            expenseGroupIdAndNameResponse.setExpenseGroupId(expenseGroup.getExpenseGroupId());
            expenseGroupIdAndNameResponse.setExpenseGroupName(expenseGroup.getExpenseGroupName());
            expenseGroupIdAndNameResponses.add(expenseGroupIdAndNameResponse);
        });
        return expenseGroupIdAndNameResponses;
    }
}
