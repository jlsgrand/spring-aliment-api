package co.simplon.aliment.exception;

public class InvalidSortingCriterionException extends RuntimeException {
    private static final String MESSAGE= "The sorting criterion %s is invalid for entity %s.";
    private String entityName;
    private String criterion;

    public InvalidSortingCriterionException(String entityName
            , String criterion ) {
        super(String.format(MESSAGE,criterion, entityName));
        this.entityName = entityName;
        this.criterion = criterion;
    }

    public String getEntityName() {
        return entityName;
    }
    public String getCriterion() {
        return criterion;
    }
}

