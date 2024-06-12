package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionRepo extends JpaRepository<Condition,Long> {
    List<Condition> findAll();
}
