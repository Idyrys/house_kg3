package kg.boosterschool.house_kg.services;

import kg.boosterschool.house_kg.models.PropertyType;

import java.util.List;

public interface PropertyTypeService {
    List<PropertyType> getAllPropertyType();
    PropertyType getReferenceById(Long id);
}
