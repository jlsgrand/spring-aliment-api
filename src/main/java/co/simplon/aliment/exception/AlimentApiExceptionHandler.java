package co.simplon.aliment.exception;

import co.simplon.aliment.dto.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Specific Exception Handler for API Rest Controllers
 */
@RestControllerAdvice
public class AlimentApiExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * How to proceed in case of an EntityNotFoundException
     *
     * @param ex the EntityNotFoundException
     * @return an API Error wrapped in a ResponseEntity with status 404.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        ApiError apiError = new ApiError(
                "001",
                "Get request with ID on Entity " + ex.getEntityName() + " returned no element",
                ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
    /**
     * How to proceed in case of an EntityNotFoundException
     *
     * @param ex the EntityNotFoundException
     * @return an API Error wrapped in a ResponseEntity with status 404.
     */
    @ExceptionHandler(InvalidSortingCriterionException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(InvalidSortingCriterionException ex) {
        ApiError apiError = new ApiError(
                "001",
                "Get request with invalid sorting criterion "+ex.getCriterion()+" on Entity " + ex.getEntityName(),
                ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }


    /**
     * How to proceed in case of an MethodArgumentNotValidException
     *
     * @param ex the MethodArgumentNotValidException
     * @param headers
     * @param status
     * @param request
     * @return an API Error wrapped in a ResponseEntity with status 400.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError(
                "002",
                "Invalid input data",
                "The provided body request is not valid, some fields might be missing or not with a good format");
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
