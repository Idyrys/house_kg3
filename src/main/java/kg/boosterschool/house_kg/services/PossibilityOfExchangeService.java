package kg.boosterschool.house_kg.services;

import kg.boosterschool.house_kg.models.PossibilityOfExchange;

import java.util.List;

public interface PossibilityOfExchangeService {
    List<PossibilityOfExchange> getAllPossibilityOfExchange();
    PossibilityOfExchange getReferenceById(Long id);
}
