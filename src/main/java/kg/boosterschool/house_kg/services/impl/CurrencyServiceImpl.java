package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.models.Currency;
import kg.boosterschool.house_kg.repositories.CurrencyRepo;
import kg.boosterschool.house_kg.services.CurrencyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepo currencyRepo;

    public CurrencyServiceImpl(CurrencyRepo currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    @Override
    public List<Currency> getAllCurrency() {
        return currencyRepo.findAll();
    }

    @Override
    public Currency getReferenceById(Long id) {
        return currencyRepo.getReferenceById(id);
    }

    @Override
    public String typeDollars() {
        return currencyRepo.typeDollars();
    }

    @Override
    public String typeSoms() {
        return currencyRepo.typeSoms();
    }
}
