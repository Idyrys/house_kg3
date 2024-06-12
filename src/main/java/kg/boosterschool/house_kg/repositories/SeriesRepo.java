package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepo extends JpaRepository<Series,Long> {
    List<Series> findAll();
}
