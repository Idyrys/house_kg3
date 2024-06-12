package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyTypeRepo extends JpaRepository<PropertyType,Long> {
    List<PropertyType> findAll();
}
