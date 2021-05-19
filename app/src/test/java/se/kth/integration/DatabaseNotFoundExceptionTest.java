package se.kth.integration;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.kth.model.Item;

/**
 * testing that DatabaseNotFoundException is thrown when it should
 */
class DatabaseNotFoundExceptionTest {


    @Test
    public void testCheckInventoryThrowsDatabaseNotFoundException() {
        ExternalInventorySystem eis = new ExternalInventorySystem();
        Item item = new Item();
        Integer itemId = 420;
        Integer wantedAmount = 2;
        Assertions.assertThrows(DatabaseFailureException.class, () -> {
            eis.checkInventory(itemId, wantedAmount);
        });
    }
}