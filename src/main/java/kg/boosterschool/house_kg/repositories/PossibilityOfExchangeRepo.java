package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.PossibilityOfExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PossibilityOfExchangeRepo extends JpaRepository<PossibilityOfExchange,Long> {
    List<PossibilityOfExchange> findAll();
}
