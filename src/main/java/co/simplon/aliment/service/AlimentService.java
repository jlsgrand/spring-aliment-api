package co.simplon.aliment.service;

import co.simplon.aliment.exception.EntityNotFoundException;
import co.simplon.aliment.model.Aliment;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface AlimentService {

    /**
     * Aliment list retrieval.
     *
     * @param pageNumber the page number to get
     * @param pageSize   the page size to choose
     * @param criteria   the sorting criteria
     * @param direction  the sorting direction
     * @return a page object with aliments
     */
    Page<Aliment> getAliments(int pageNumber, int pageSize, String criteria, String direction);

    /**
     * Get one aliment with its ID.
     *
     * @param alimentId the aliment ID to look for.
     * @return the aliment if ID is found in DB.
     * @throws EntityNotFoundException in case ID is not found in DB.
     */
    Aliment getAlimentById(Long alimentId) throws EntityNotFoundException;

    /**
     * Creates one aliment.
     *
     * @param newAliment the new Aliment to create.
     * @return the created aliment.
     */
    Aliment createAliment(Aliment newAliment);
}
