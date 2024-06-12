package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRateRepo extends JpaRepository<ExchangeRate,Long> {
    @Query(value = "SELECT e.course FROM Exchange_Rate e WHERE e.active = true and e.end_date >= CURRENT_TIMESTAMP;",nativeQuery = true)
    double findActiveExchangeRates();
}
