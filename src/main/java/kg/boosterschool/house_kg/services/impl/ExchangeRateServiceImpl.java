package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.models.ExchangeRate;
import kg.boosterschool.house_kg.repositories.ExchangeRateRepo;
import kg.boosterschool.house_kg.services.ExchangeRateService;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final ExchangeRateRepo exchangeRateRepo;

    public ExchangeRateServiceImpl(ExchangeRateRepo exchangeRateRepo) {
        this.exchangeRateRepo = exchangeRateRepo;
    }

    @Override
    public double findActiveExchangeRates() {
        return exchangeRateRepo.findActiveExchangeRates();
    }
}
