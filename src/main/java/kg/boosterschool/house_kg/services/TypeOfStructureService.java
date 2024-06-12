package kg.boosterschool.house_kg.services;

import kg.boosterschool.house_kg.models.TypeOfStructure;

import java.util.List;

public interface TypeOfStructureService {
    List<TypeOfStructure> getAllTypeOfStructure();
    TypeOfStructure getReferenceById(Long id);
}
