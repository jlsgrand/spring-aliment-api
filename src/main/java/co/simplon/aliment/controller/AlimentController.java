package co.simplon.aliment.controller;

import co.simplon.aliment.exception.EntityNotFoundException;
import co.simplon.aliment.model.Aliment;
import co.simplon.aliment.service.AlimentService;
import co.simplon.aliment.utility.Reflection;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/aliments")
public class AlimentController {

    private AlimentService alimentService;

    public AlimentController(AlimentService alimentService) {
        this.alimentService = alimentService;
    }

    /**
     * Controller method enabling Aliment list retrieval with pagination and sorting.
     *
     * @param pageNumber the page number we want to get (default is 0)
     * @param pageSize   the page size we want to define (default is 50)
     * @param criteria   the sorting criteria (default is aliment name)
     * @param direction  the sorting direction (default is ascending)
     * @return a Page object containing Aliments.
     */
    @GetMapping
    public Page<Aliment> getAliments(
            @ApiParam(value = "Query param for 'pageNumber'") @Valid @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
            @ApiParam(value = "Query param for 'pageSize'") @Valid @RequestParam(value = "pageSize", defaultValue = "50") Integer pageSize,
            @ApiParam(value = "Query param for 'sort' criteria") @Valid @RequestParam(value = "sort", defaultValue = "name") String criteria,
            @ApiParam(value = "Query param for 'sort' direction") @Valid @RequestParam(value = "direction", defaultValue = "asc") String direction) {
        criteria= Reflection.fieldNameOrDefault(Aliment.class,criteria,"name");
        return alimentService.getAliments(pageNumber, pageSize, criteria, direction);
    }

    /**
     * Getting an Aliment with its ID.
     *
     * @param alimentId the aliment ID to look for.
     * @return  the aliment if found, an Entity not found Exception otherwise
     * @see co.simplon.aliment.exception.AlimentApiExceptionHandler#handleEntityNotFoundException(EntityNotFoundException) for Exception handling
     */
    @GetMapping("/{alimentId}")
    public Aliment getAlimentById(@PathVariable Long alimentId) {
        return alimentService.getAlimentById(alimentId);
    }

    /**
     * Creating an aliment.
     *
     * @param newAliment the new aliment to create (should be valid)
     * @return the created aliment if valid, MethodArgumentNotValidException otherwise
     * @see co.simplon.aliment.exception.AlimentApiExceptionHandler#handleMethodArgumentNotValid(MethodArgumentNotValidException, HttpHeaders, HttpStatus, WebRequest)
     *      for Exception handling
     */
    @PostMapping
    public Aliment createAliment(@RequestBody @Valid Aliment newAliment) {
        return alimentService.createAliment(newAliment);
    }
}
