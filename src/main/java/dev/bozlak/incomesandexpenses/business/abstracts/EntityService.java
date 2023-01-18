package dev.bozlak.incomesandexpenses.business.abstracts;

import dev.bozlak.incomesandexpenses.core.results.Result;

import java.util.List;

public interface EntityService<TCreateRequest,TUpdateRequest,TPrimaryKeyDataType,TGetAllColumnResponse> {
    Result add(TCreateRequest createEntityDto);
    Result update(TUpdateRequest updateEntityDto);
    Result deleteById(TPrimaryKeyDataType id);
    List<TGetAllColumnResponse> getAll();
    TGetAllColumnResponse getById(TPrimaryKeyDataType id);
}
