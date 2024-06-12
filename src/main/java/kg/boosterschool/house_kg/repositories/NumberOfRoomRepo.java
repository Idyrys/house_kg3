package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.NumberOfRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumberOfRoomRepo extends JpaRepository<NumberOfRoom,Long> {
    List<NumberOfRoom> findAll();
}
