package se.kth.integration;

public class DatabaseNotFoundException extends Exception {

    /**
     * Creates a new DataBaseNotFoundException
     *
     * @param message the detailed message to show
     */
    public DatabaseNotFoundException(String message) {
        super(message);
    }

    /**
     * allows chaining of exceptions
     *
     * @param message   the detailed message to show
     * @param throwable the exception to chain with
     */
    public DatabaseNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
