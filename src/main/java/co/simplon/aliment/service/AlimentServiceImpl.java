package co.simplon.aliment.service;

import co.simplon.aliment.exception.EntityNotFoundException;
import co.simplon.aliment.model.Aliment;
import co.simplon.aliment.repository.AlimentRepository;
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
    public Page<Aliment> getAliments(Integer pageNumber, Integer pageSize, String criteria, String direction) {
        // If page number is not null then use it for paging, otherwise provide page 0
        int pNumber = (pageNumber != null) ? pageNumber : 0;
        // If page size is not null then use it for paging, otherwise use default 50 page size
        int pSize = (pageSize != null) ? pageSize : 50;

        // By default sort on aliment name
        String sortingCriteria = "name";

        // If sorting criteria matches an aliment field name, then use it for sorting
        Field[] fields = Aliment.class.getDeclaredFields();
        List<String> possibleCriteria = new ArrayList<>();
        for (Field field : fields) {
            possibleCriteria.add(field.getName().toLowerCase());
        }
        if (criteria != null && possibleCriteria.contains(criteria)) {
            sortingCriteria = criteria;
        }

        // By default sorting ascending, but if user explicitely choose desc, then sort descending
        Sort.Direction sortingDirection = Sort.Direction.ASC;
        if (direction != null) {
            sortingDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        }

        return alimentRepository.findAll(PageRequest.of(pNumber, pSize, Sort.by(sortingDirection, sortingCriteria)));
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
