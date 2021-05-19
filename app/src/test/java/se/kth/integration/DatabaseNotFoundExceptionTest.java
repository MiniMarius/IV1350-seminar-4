package se.kth.integration;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * testing that DatabaseNotFoundException is thrown when it should
 */
class DatabaseNotFoundExceptionTest {

    @Test
    public void getTestCheckInventoryJunit3() {
        ExternalInventorySystem eis = new ExternalInventorySystem();
        Integer ItemId = 420;
        Integer wantedAmount = 5;

    }


    @Test
    public void testCheckInventoryThrowsDatabaseNotFoundException() {
        ExternalInventorySystem eis = new ExternalInventorySystem();
        Integer itemId = 420;
        Integer wantedAmount = 2;
        Throwable exception = Assertions.assertThrows(DatabaseFailureException.class, () -> {
            eis.checkInventory(itemId, wantedAmount);
        });
        Assertions.assertTrue(exception.getMessage().equals("database connection timed out"));
    }

    @Test
    public void testCheckInventory



}