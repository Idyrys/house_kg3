package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.TypeOfStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeOfStructureRepo extends JpaRepository<TypeOfStructure,Long> {
    List<TypeOfStructure> findAll();
}
