package se.kth.integration;

public class DatabaseFailureException extends Exception {

    /**
     * Creates a new DataBaseNotFoundException
     *
     * @param message the detailed message to show
     */
    public DatabaseFailureException(String message) {
        super(message);
    }

    /**
     * allows chaining of exceptions
     *
     * @param message   the detailed message to show
     * @param throwable the exception to chain with
     */
    public DatabaseFailureException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
