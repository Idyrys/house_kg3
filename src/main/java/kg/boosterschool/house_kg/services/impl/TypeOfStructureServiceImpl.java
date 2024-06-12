package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.models.TypeOfStructure;
import kg.boosterschool.house_kg.repositories.TypeOfStructureRepo;
import kg.boosterschool.house_kg.services.TypeOfStructureService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeOfStructureServiceImpl implements TypeOfStructureService {
    private final TypeOfStructureRepo typeOfStructureRepo;

    public TypeOfStructureServiceImpl(TypeOfStructureRepo typeOfStructureRepo) {
        this.typeOfStructureRepo = typeOfStructureRepo;
    }

    @Override
    public List<TypeOfStructure> getAllTypeOfStructure() {
        return typeOfStructureRepo.findAll();
    }
}
