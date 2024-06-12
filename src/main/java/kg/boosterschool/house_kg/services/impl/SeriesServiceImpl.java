package kg.boosterschool.house_kg.services.impl;

import kg.boosterschool.house_kg.models.Series;
import kg.boosterschool.house_kg.repositories.SeriesRepo;
import kg.boosterschool.house_kg.services.SeriesService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeriesServiceImpl implements SeriesService {
    private final SeriesRepo seriesRepo;

    public SeriesServiceImpl(SeriesRepo seriesRepo) {
        this.seriesRepo = seriesRepo;
    }

    @Override
    public List<Series> getAllSeries() {
        return seriesRepo.findAll();
    }

    @Override
    public Series getReferenceById(Long id) {
        return seriesRepo.getReferenceById(id);
    }
}
