package co.simplon.aliment.service;

import co.simplon.aliment.exception.EntityNotFoundException;
import co.simplon.aliment.exception.InvalidSortingCriterionException;
import co.simplon.aliment.model.Aliment;
import co.simplon.aliment.repository.AlimentRepository;
import co.simplon.aliment.utility.Reflection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<Aliment> getAliments(int pNumber, int pSize, String criteria, String direction) {
        // By default sorting ascending, but if user explicitly choose desc, then sort descending
        if(!Reflection.isFieldName(Aliment.class, criteria)){
            throw new InvalidSortingCriterionException(Aliment.class.getName(),criteria);
        }
        Sort.Direction sortingDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        return alimentRepository.findAll(PageRequest.of(pNumber, pSize, Sort.by(sortingDirection, criteria)));
    }

    @Override
    public Aliment getAlimentById(Long alimentId) throws EntityNotFoundException {
        Optional<Aliment> dbAliment = alimentRepository.findById(alimentId);

        if (dbAliment.isPresent()) {
            return dbAliment.get();
        } else {
            throw new EntityNotFoundException(alimentId, "Aliment");
        }
    }

    @Override
    public Aliment createAliment(Aliment newAliment) {
        return alimentRepository.save(newAliment);
    }
}
