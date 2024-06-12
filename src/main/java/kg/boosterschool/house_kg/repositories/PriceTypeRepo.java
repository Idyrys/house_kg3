package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.PriceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceTypeRepo extends JpaRepository<PriceType,Long> {
    List<PriceType> findAll();
    @Query(value = "select p.name from price_types p where p.id = 1 and p.active = true;",nativeQuery = true)
    String typeForAll();

    @Query(value = "select p.name from price_types p where p.id = 2 and p.active = true;",nativeQuery = true)
    String typePerSquareMeter();
}
