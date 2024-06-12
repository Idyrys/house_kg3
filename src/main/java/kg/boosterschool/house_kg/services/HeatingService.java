package kg.boosterschool.house_kg.services;

import kg.boosterschool.house_kg.models.Heating;

import java.util.List;

public interface HeatingService {
    List<Heating> getAllHeating();
    Heating getReferenceById(Long id);
}
