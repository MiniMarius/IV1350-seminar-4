package se.kth.integration;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * testing that DatabaseNotFoundException is thrown when it should
 */
class DatabaseNotFoundExceptionTest {

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