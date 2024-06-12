package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.MortgageOrInstallmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MortgageOrInstallmentPlanRepo extends JpaRepository<MortgageOrInstallmentPlan,Long> {
    List<MortgageOrInstallmentPlan> findAll();
}
