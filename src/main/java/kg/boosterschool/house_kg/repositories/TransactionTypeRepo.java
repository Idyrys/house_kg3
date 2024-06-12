package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionTypeRepo extends JpaRepository<TransactionType, Long> {
    List<TransactionType> findAll();
}
