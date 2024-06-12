package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.dto.LocationDto;
import kg.boosterschool.house_kg.models.Location;
import kg.boosterschool.house_kg.repositories.LocationRepo;
import kg.boosterschool.house_kg.services.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepo locationRepo;

    public LocationServiceImpl(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    @Override
    public List<LocationDto> getAllLocation(Long id) {
        return locationRepo.findByLocationId(id)
                .stream()
                .map(location -> new LocationDto(location.getId(), location.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Location getReferenceById(Long id) {
        return locationRepo.getReferenceById(id);
    }

}
