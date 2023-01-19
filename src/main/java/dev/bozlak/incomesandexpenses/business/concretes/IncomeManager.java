package dev.bozlak.incomesandexpenses.business.concretes;

import dev.bozlak.incomesandexpenses.business.abstracts.IncomeService;
import dev.bozlak.incomesandexpenses.core.results.ErrorResult;
import dev.bozlak.incomesandexpenses.core.results.Result;
import dev.bozlak.incomesandexpenses.core.results.SuccessResult;
import dev.bozlak.incomesandexpenses.dtos.concretes.Income.CreateIncomeRequest;
import dev.bozlak.incomesandexpenses.dtos.concretes.Income.IncomeGetAllColumnResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.Income.UpdateIncomeRequest;
import dev.bozlak.incomesandexpenses.entities.concretes.Income;
import dev.bozlak.incomesandexpenses.repositories.abstracts.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeManager implements IncomeService {
    private IncomeRepository incomeRepository;

    public IncomeManager(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public Result add(CreateIncomeRequest createEntityDto) {
        Income income = new Income();
        income.setIncomeGroupId(createEntityDto.getIncomeGroupId());
        income.setIncomeAmount(createEntityDto.getIncomeAmount());
        income.setDate(createEntityDto.getDate());
        income.setDescription(createEntityDto.getDescription());
        Income returnedIncome = this.incomeRepository.save(income);
        if (returnedIncome != null)
            return new SuccessResult();
        return new ErrorResult();
    }

    @Override
    public Result update(UpdateIncomeRequest updateEntityDto) {
        Income income = new Income();
        income.setIncomeId(updateEntityDto.getIncomeId());
        income.setIncomeGroupId(updateEntityDto.getIncomeGroupId());
        income.setIncomeAmount(updateEntityDto.getIncomeAmount());
        income.setDate(updateEntityDto.getDate());
        income.setDescription(updateEntityDto.getDescription());
        Income returnedIncome = this.incomeRepository.save(income);
        if (returnedIncome != null)
            return new SuccessResult();
        return new ErrorResult();
    }

    @Override
    public Result deleteById(Integer id) {
        this.incomeRepository.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public List<IncomeGetAllColumnResponse> getAll() {
        List<Income> incomes = this.incomeRepository.findAll();
        List<IncomeGetAllColumnResponse> incomeGetAllColumnResponses = new ArrayList<>();
        incomes.forEach(income -> {
            IncomeGetAllColumnResponse incomeGetAllColumnResponse = new IncomeGetAllColumnResponse();
            incomeGetAllColumnResponse.setIncomeId(income.getIncomeId());
            incomeGetAllColumnResponse.setIncomeGroupId(income.getIncomeGroupId());
            incomeGetAllColumnResponse.setIncomeAmount(income.getIncomeAmount());
            incomeGetAllColumnResponse.setDate(income.getDate());
            incomeGetAllColumnResponse.setDescription(income.getDescription());
            incomeGetAllColumnResponses.add(incomeGetAllColumnResponse);
        });
        return incomeGetAllColumnResponses;
    }

    @Override
    public IncomeGetAllColumnResponse getById(Integer id) {
        Income income = this.incomeRepository.getReferenceById(id);
        IncomeGetAllColumnResponse incomeGetAllColumnResponse = new IncomeGetAllColumnResponse();
        incomeGetAllColumnResponse.setIncomeId(income.getIncomeId());
        incomeGetAllColumnResponse.setIncomeGroupId(income.getIncomeGroupId());
        incomeGetAllColumnResponse.setIncomeAmount(incomeGetAllColumnResponse.getIncomeAmount());
        incomeGetAllColumnResponse.setDate(income.getDate());
        incomeGetAllColumnResponse.setDescription(incomeGetAllColumnResponse.getDescription());
        return incomeGetAllColumnResponse;
    }
}
