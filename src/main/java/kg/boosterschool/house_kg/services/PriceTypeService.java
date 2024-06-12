package kg.boosterschool.house_kg.services;

import kg.boosterschool.house_kg.models.PriceType;

import java.util.List;

public interface PriceTypeService {
    List<PriceType> getAllPriceType();
    PriceType getReferenceById(Long id);
    String typeForAll();
    String typePerSquareMeter();
}
