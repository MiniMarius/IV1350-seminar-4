package se.kth.integration;

public class ItemNotFoundException extends Exception {

    /**
     * Creates a new ItemNotFoundException
     *
     * @param message the detailed message to show
     */
    public ItemNotFoundException(String message) {
        super(message);
    }

    /**
     * Allows chaining of exceptions
     *
     * @param message   the detailed message to show
     * @param throwable the exception to be chained with
     */
    public ItemNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
