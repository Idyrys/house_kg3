package kg.boosterschool.house_kg.services;

import kg.boosterschool.house_kg.dto.LocationDto;

import java.util.List;

public interface LocationService {
    List<LocationDto> getAllLocation(Long id);

}
