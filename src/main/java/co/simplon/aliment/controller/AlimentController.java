package co.simplon.aliment.controller;

import co.simplon.aliment.exception.EntityNotFoundException;
import co.simplon.aliment.model.Aliment;
import co.simplon.aliment.service.AlimentService;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Parameter;
//import org.springdoc.core.converters.Pageable;
import org.springframework.data.domain.Pageable;
import org.springdoc.core.converters.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

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
     * @param pageable parameters of the page we want to get
     * @return a Page object containing Aliments.
     */
    @GetMapping("")
    @PageableAsQueryParam
    public Page<Aliment> getAliments(
            @PageableDefault(size=8) @Parameter(hidden=true) Pageable pageable) {
        return alimentService.getAliments(pageable);
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
