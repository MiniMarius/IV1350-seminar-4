package se.kth.view;

import se.kth.integration.ItemNotFoundException;
import se.kth.controller.Controller;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * View will simulate user input
 */
public class View {
    private Controller controller;

    /**
     * Creates a view object, representing a view of mvc-architecture
     *
     * @param controller makes all of the calls
     */
    public View(Controller controller) {
        this.controller = controller;
        controller.addSaleObserver(new TotalRevenueView());
        controller.addSaleObserver(new TotalRevenueFileOutput());
    }


    /**
     * Sample execution of application, simulating user input
     */
    public void sampleExecution() {
        controller.makeNewSale();
        System.out.println("New sale started");
        System.out.println("Scanning items");

        showSaleInfo(3, 1);
        showSaleInfo(11, 1);
        showSaleInfo(3, 5);
        showSaleInfo(420, 1);
        showSaleInfo(6, 1);


        System.out.println("Sale ended" + "\n" + "Total with taxes: " + controller.endSale());
        System.out.println("Discounted Total with taxes: " + controller.discountRequest(8));
        System.out.println("Handing over payment");
        Double change = controller.makePayment(500.00);
    }

    /**
     * Calls controller for item with requested itemId and amount.
     * Attempts to print running sale info.
     * Catches exceptions and shows info to user.
     * Calls method responsible for logging if exception is not part of business logic
     *
     * @param itemID       the itemId to be searched for
     * @param amountOfItem the amount of said item to search for
     */
    private void showSaleInfo(Integer itemID, Integer amountOfItem) {
        try {
            System.out.println((controller.enterItem(itemID, amountOfItem)));
        }
        catch (ItemNotFoundException exception) {
            System.out.println("ERROR: Item with itemID " + itemID + " not found");
        }
        catch (Exception exception) {
            System.out.println("ERROR: Unexpected error, please try again");
            logException(exception);
        }
    }

    /**
     * logs exceptions and outputs this to a log file.
     *
     * @param exception the exception to be logged
     */
    private void logException(Exception exception) {
        try {
            FileHandler fileHandler = new FileHandler("errorlog.txt", 1000000, 1, true);
            Logger logger = Logger.getLogger(View.class.getName());
            logger.setUseParentHandlers(false);
            logger.addHandler(fileHandler);
            logger.log(Level.SEVERE, exception.getMessage(), exception);
            fileHandler.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
