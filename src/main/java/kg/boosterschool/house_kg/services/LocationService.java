package kg.boosterschool.house_kg.services;

import kg.boosterschool.house_kg.dto.responseDto.LocationDto;
import kg.boosterschool.house_kg.models.Location;

import java.util.List;

public interface LocationService {
    List<LocationDto> getAllLocation(Long id);
    Location getReferenceById(Long id);
    String getRegion(String name);
    String getSettlement(String name);

}
