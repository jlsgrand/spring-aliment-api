package co.simplon.aliment.exception;

/**
 * Specific API entity not found exception
 */
public class EntityNotFoundException extends RuntimeException {
    private static final String MESSAGE= "The entity with ID: %s cannot be found in DB";
    private String entityName;

    public EntityNotFoundException(long id, String entityName) {
        super(String.format(MESSAGE, id));
        this.entityName = entityName;
    }

    public String getEntityName() {
        return entityName;
    }
}
