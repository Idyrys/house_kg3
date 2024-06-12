package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.models.PropertyType;
import kg.boosterschool.house_kg.repositories.PropertyTypeRepo;
import kg.boosterschool.house_kg.services.PropertyTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyTypeServiceImpl implements PropertyTypeService {
    private final PropertyTypeRepo propertyTypeRepo;

    public PropertyTypeServiceImpl(PropertyTypeRepo propertyTypeRepo) {
        this.propertyTypeRepo = propertyTypeRepo;
    }

    @Override
    public List<PropertyType> getAllPropertyType() {
        return propertyTypeRepo.findAll();
    }

    @Override
    public PropertyType getReferenceById(Long id) {
        return propertyTypeRepo.getReferenceById(id);
    }
}
