package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.models.PriceType;
import kg.boosterschool.house_kg.repositories.PriceTypeRepo;
import kg.boosterschool.house_kg.services.PriceTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceTypeServiceImpl implements PriceTypeService {
    private final PriceTypeRepo priceTypeRepo;

    public PriceTypeServiceImpl(PriceTypeRepo priceTypeRepo) {
        this.priceTypeRepo = priceTypeRepo;
    }

    @Override
    public List<PriceType> getAllPriceType() {
        return priceTypeRepo.findAll();
    }
}
