package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.Heating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeatingRepo extends JpaRepository<Heating,Long> {
    List<Heating> findAll();
}
