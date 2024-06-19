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

    @Query(value = "Select l3.name from locations l3 where id =(\n" +
            "Select l2.id_locations from locations l2 where id =(\n" +
            "select  l1.id_locations from locations l1\n" +
            "\twhere upper(l1.name) =upper(:name)));",nativeQuery = true)
    String getRegion(String name);

    @Query(value = "Select l2.name from locations l2 where id =(\n" +
            "select  l1.id_locations from locations l1\n" +
            "\twhere upper(l1.name) =upper(:name))",nativeQuery = true)
    String getSettlement(String name);


}
