package kg.boosterschool.house_kg.services;

import kg.boosterschool.house_kg.dto.requestDto.OurPropertyDto;
import kg.boosterschool.house_kg.dto.responseDto.OurPropertyResponseDto;
import kg.boosterschool.house_kg.models.OurProperty;


import java.util.List;

public interface OurPropertyService {
    String createOurProperty(OurPropertyDto ourPropertyDto);

    List<OurPropertyResponseDto> getALlOurPropertyMapper(List<OurProperty> ourProperties);

    List<String> getAllOurPropertyResponseDto();

    List<OurProperty> getAllOurPropertyByParameters(
            int page, int pageSize,
            Integer floor, Integer yearBuilt ,String dealType,
            String propertyType ,Integer roomCount ,String series,
            String buildingType, String heating, String condition,
            String region, String settlement, String district,
            String streetName, String houseNumber, Double priceMin,
            Double priceMax, String currency, String priceType,
            String installmentPlan,String mortgage, String exchangeOption
    );



}
