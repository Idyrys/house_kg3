package kg.boosterschool.house_kg.repositories;

import jakarta.transaction.Transactional;
import kg.boosterschool.house_kg.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Location,Long> {
    List<Location> findByLocationId(Long id);



}
