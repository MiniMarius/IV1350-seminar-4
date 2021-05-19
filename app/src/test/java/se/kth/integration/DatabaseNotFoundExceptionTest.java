package se.kth.integration;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * testing that DatabaseNotFoundException is thrown when it should
 */
class DatabaseNotFoundExceptionTest {

    /**
     * checks that DataBaseFailureException is thrown when the itemId is equal to the
     * hardcoded throwing Integer 420. Done in junit3 style.
     */
    @Test
    public void getTestCheckInventoryThrowsDataBaseFailureExceptionJunit3Style() {
        ExternalInventorySystem eis = new ExternalInventorySystem();
        Integer itemId = 420;
        Integer wantedAmount = 5;
        try {
            eis.checkInventory(itemId, wantedAmount);
            fail("Missed exception");
        }
        catch (DatabaseFailureException | ItemNotFoundException e) {
            assertEquals("database connection timed out", e.getMessage());
        }
    }

    /**
     * same as above but junit5 style
     */
    @Test
    public void testCheckInventoryThrowsDatabaseNotFoundException() {
        ExternalInventorySystem eis = new ExternalInventorySystem();
        Integer itemId = 420;
        Integer wantedAmount = 2;
        Throwable exception = Assertions.assertThrows(DatabaseFailureException.class, () -> {
            eis.checkInventory(itemId, wantedAmount);
        });
        Assertions.assertEquals(exception.getMessage(), "database connection timed out");
    }
}