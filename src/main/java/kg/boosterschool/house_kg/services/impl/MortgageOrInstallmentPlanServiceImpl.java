package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.models.MortgageOrInstallmentPlan;
import kg.boosterschool.house_kg.repositories.MortgageOrInstallmentPlanRepo;
import kg.boosterschool.house_kg.services.MortgageOrInstallmentPlanService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MortgageOrInstallmentPlanServiceImpl implements MortgageOrInstallmentPlanService {
    private final MortgageOrInstallmentPlanRepo mortgageOrInstallmentPlanRepo;

    public MortgageOrInstallmentPlanServiceImpl(MortgageOrInstallmentPlanRepo mortgageOrInstallmentPlanRepo) {
        this.mortgageOrInstallmentPlanRepo = mortgageOrInstallmentPlanRepo;
    }

    @Override
    public List<MortgageOrInstallmentPlan> getAllMortgageOrInstallmentPlan() {
        return mortgageOrInstallmentPlanRepo.findAll();
    }

    @Override
    public MortgageOrInstallmentPlan getReferenceById(Long id) {
        return mortgageOrInstallmentPlanRepo.getReferenceById(id);
    }
}
