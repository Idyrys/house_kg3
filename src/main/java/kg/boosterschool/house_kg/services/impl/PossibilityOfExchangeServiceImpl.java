package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.models.PossibilityOfExchange;
import kg.boosterschool.house_kg.repositories.PossibilityOfExchangeRepo;
import kg.boosterschool.house_kg.services.PossibilityOfExchangeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PossibilityOfExchangeServiceImpl implements PossibilityOfExchangeService {
    private final PossibilityOfExchangeRepo possibilityOfExchangeRepo;

    public PossibilityOfExchangeServiceImpl(PossibilityOfExchangeRepo possibilityOfExchangeRepo) {
        this.possibilityOfExchangeRepo = possibilityOfExchangeRepo;
    }

    @Override
    public List<PossibilityOfExchange> getAllPossibilityOfExchange() {
        return possibilityOfExchangeRepo.findAll();
    }

    @Override
    public PossibilityOfExchange getReferenceById(Long id) {
        return possibilityOfExchangeRepo.getReferenceById(id);
    }
}
