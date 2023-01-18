package dev.bozlak.incomesandexpenses.business.concretes;

import dev.bozlak.incomesandexpenses.business.abstracts.IncomeGroupService;
import dev.bozlak.incomesandexpenses.core.results.ErrorResult;
import dev.bozlak.incomesandexpenses.core.results.Result;
import dev.bozlak.incomesandexpenses.core.results.SuccessResult;
import dev.bozlak.incomesandexpenses.dtos.concretes.IncomeGroup.CreateIncomeGroupRequest;
import dev.bozlak.incomesandexpenses.dtos.concretes.IncomeGroup.IncomeGroupGetAllColumnResponse;
import dev.bozlak.incomesandexpenses.dtos.concretes.IncomeGroup.UpdateIncomeGroupRequest;
import dev.bozlak.incomesandexpenses.entities.concretes.IncomeGroup;
import dev.bozlak.incomesandexpenses.repositories.abstracts.IncomeGroupRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeGroupManager implements IncomeGroupService {
    private IncomeGroupRepository incomeGroupRepository;

    public IncomeGroupManager(IncomeGroupRepository incomeGroupRepository) {
        this.incomeGroupRepository = incomeGroupRepository;
    }

    @Override
    public Result add(CreateIncomeGroupRequest createEntityDto) {
        IncomeGroup incomeGroup = new IncomeGroup();
        incomeGroup.setIncomeGroupName(createEntityDto.getIncomeGroupName());
        incomeGroup.setDescription(createEntityDto.getDescription());
        IncomeGroup returnedIncomeGroup = this.incomeGroupRepository.save(incomeGroup);
        if (returnedIncomeGroup != null)
            return new SuccessResult();
        return new ErrorResult();
    }

    @Override
    public Result update(UpdateIncomeGroupRequest updateEntityDto) {
        IncomeGroup incomeGroup = new IncomeGroup();
        incomeGroup.setIncomeGroupId(updateEntityDto.getIncomeGroupId());
        incomeGroup.setIncomeGroupName(updateEntityDto.getIncomeGroupName());
        incomeGroup.setDescription(updateEntityDto.getDescription());
        IncomeGroup returnedIncomeGroup = this.incomeGroupRepository.save(incomeGroup);
        if (returnedIncomeGroup != null)
            return new SuccessResult();
        return new ErrorResult();
    }

    @Override
    public Result deleteById(Integer id) {
        this.incomeGroupRepository.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public List<IncomeGroupGetAllColumnResponse> getAll() {
        List<IncomeGroup> incomeGroups = this.incomeGroupRepository.findAll();
        List<IncomeGroupGetAllColumnResponse> incomeGroupGetAllColumnResponses = new ArrayList<>();
        incomeGroups.forEach(incomeGroup -> {
            IncomeGroupGetAllColumnResponse incomeGroupGetAllColumnResponse = new IncomeGroupGetAllColumnResponse();
            incomeGroupGetAllColumnResponse.setIncomeGroupId(incomeGroup.getIncomeGroupId());
            incomeGroupGetAllColumnResponse.setIncomeGroupName(incomeGroup.getIncomeGroupName());
            incomeGroupGetAllColumnResponse.setDescription(incomeGroup.getDescription());
            incomeGroupGetAllColumnResponses.add(incomeGroupGetAllColumnResponse);
        });
        return incomeGroupGetAllColumnResponses;
    }

    @Override
    public IncomeGroupGetAllColumnResponse getById(Integer id) {
        IncomeGroupGetAllColumnResponse incomeGroupGetAllColumnResponse = new IncomeGroupGetAllColumnResponse();
        IncomeGroup incomeGroup = this.incomeGroupRepository.getReferenceById(id);
        incomeGroupGetAllColumnResponse.setIncomeGroupId(incomeGroup.getIncomeGroupId());
        incomeGroupGetAllColumnResponse.setIncomeGroupName(incomeGroup.getIncomeGroupName());
        incomeGroupGetAllColumnResponse.setDescription(incomeGroupGetAllColumnResponse.getDescription());
        return incomeGroupGetAllColumnResponse;
    }
}
