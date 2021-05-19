package se.kth.startup;

import se.kth.integration.*;
import se.kth.controller.*;
import se.kth.view.*;

/**
 * Does a startup of all the necessary components of the application
 */
public class Main {

    /**
     * Starts the application
     *
     * @param args No arguments are given to main
     */
    public static void main(String[] args) {

        Printer printer = new Printer();
        DiscountCatalog discountCatalog = new DiscountCatalog(8);
        ExternalAccountingSystem externalAccountingSystem = new ExternalAccountingSystem();
        ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();
        Controller controller = new Controller(printer, discountCatalog, externalAccountingSystem, externalInventorySystem);
        View view = new View(controller);
        view.sampleExecution();
    }
}
