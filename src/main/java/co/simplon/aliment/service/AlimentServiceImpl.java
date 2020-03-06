package co.simplon.aliment.service;

import co.simplon.aliment.exception.EntityNotFoundException;
import co.simplon.aliment.model.Aliment;
import co.simplon.aliment.repository.AlimentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlimentServiceImpl implements AlimentService {

    private AlimentRepository alimentRepository;

    public AlimentServiceImpl(AlimentRepository alimentRepository) {
        this.alimentRepository = alimentRepository;
    }
    @Override
    public Page<Aliment> getAliments(Pageable page){
        return alimentRepository.findAll(page);
    }

    @Override
    public Aliment getAlimentById(Long alimentId) throws EntityNotFoundException {
        Optional<Aliment> dbAliment = alimentRepository.findById(alimentId);

        if (dbAliment.isPresent()) {
            return dbAliment.get();
        } else {
            throw new EntityNotFoundException("The aliment with ID: " + alimentId + " cannot be found in DB", "Aliment");
        }
    }

    @Override
    public Aliment createAliment(Aliment newAliment) {
        return alimentRepository.save(newAliment);
    }
}
