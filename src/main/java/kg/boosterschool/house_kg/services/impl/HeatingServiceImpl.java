package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.models.Heating;
import kg.boosterschool.house_kg.repositories.HeatingRepo;
import kg.boosterschool.house_kg.services.HeatingService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HeatingServiceImpl implements HeatingService {
    private final HeatingRepo heatingRepo;

    public HeatingServiceImpl(HeatingRepo heatingRepo) {
        this.heatingRepo = heatingRepo;
    }

    @Override
    public List<Heating> getAllHeating() {
        return heatingRepo.findAll();
    }
}
