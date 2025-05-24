package com.crud.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.crud.model.TechClass;
import com.crud.repository.TechClassRepository;

@Service
public class TechClassService {
    private final TechClassRepository techClassRepository;

    public TechClassService(TechClassRepository techClassRepository) {
        this.techClassRepository = techClassRepository;
    }

    public TechClass createClass(TechClass techClass) {
        return techClassRepository.save(techClass);
    }

    public List<TechClass> getAllClass() {
        return techClassRepository.findAll();
    }

    public Optional<TechClass> getClassById(Long id) {
        return techClassRepository.findById(id);
    }

    public void deleteClassById(Long id) {
        techClassRepository.deleteById(id);
    }
}
