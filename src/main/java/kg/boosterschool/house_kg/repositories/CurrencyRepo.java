package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency,Long> {
    List<Currency> findAll();

    @Query(value = "select c.name from currencies c where  c.id = 1 and c.active = true",nativeQuery = true)
    String typeDollars();

    @Query(value = "select c.name from currencies c where  c.id = 2 and c.active = true",nativeQuery = true)
    String typeSoms();
}
