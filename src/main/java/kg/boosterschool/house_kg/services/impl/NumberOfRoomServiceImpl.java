package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.models.NumberOfRoom;
import kg.boosterschool.house_kg.repositories.NumberOfRoomRepo;
import kg.boosterschool.house_kg.services.NumberOfRoomService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NumberOfRoomServiceImpl implements NumberOfRoomService {
    private final NumberOfRoomRepo numberOfRoomRepo;

    public NumberOfRoomServiceImpl(NumberOfRoomRepo numberOfRoomRepo) {
        this.numberOfRoomRepo = numberOfRoomRepo;
    }

    @Override
    public List<NumberOfRoom> getAllNumberOfRoom() {
        return numberOfRoomRepo.findAll();
    }
}
