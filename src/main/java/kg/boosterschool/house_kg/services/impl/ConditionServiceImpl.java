package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.models.Condition;
import kg.boosterschool.house_kg.repositories.ConditionRepo;
import kg.boosterschool.house_kg.services.ConditionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConditionServiceImpl implements ConditionService {
    private final ConditionRepo conditionRepo;

    public ConditionServiceImpl(ConditionRepo conditionRepo) {
        this.conditionRepo = conditionRepo;
    }

    @Override
    public List<Condition> getAllCondition() {
        return conditionRepo.findAll();
    }
}
