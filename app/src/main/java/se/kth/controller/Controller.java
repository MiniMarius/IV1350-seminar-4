package se.kth.controller;

import se.kth.integration.*;
import se.kth.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The application's controller. Responsible for all the calls to the model
 * Methods are expected to be called in a certain order
 */
public class Controller {
    private ExternalInventorySystem externalInventorySystem;
    private ExternalAccountingSystem externalAccountingSystem;
    private Printer printer;
    private Register register;
    private DiscountCatalog discountCatalog;
    private Discount discount;
    private Sale sale;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    /**
     * @param printer                  is used to get access to printer used in POS
     * @param discountCatalog          Is used to access discount catalog for discount request
     * @param externalAccountingSystem Is used to access accounting system to save sale information into
     * @param externalInventorySystem  Is used to access items currently in stock in inventory
     */
    public Controller(Printer printer, DiscountCatalog discountCatalog, ExternalAccountingSystem externalAccountingSystem, ExternalInventorySystem externalInventorySystem) {
        this.printer = printer;
        this.discountCatalog = discountCatalog;
        this.externalAccountingSystem = externalAccountingSystem;
        this.externalInventorySystem = externalInventorySystem;
        register = new Register();
    }

    /**
     * If item identifier entered is matched with item in inventory system we will add it to the sale
     *
     * @param itemId        the id of the item we are looking for in inventory system
     * @param amountOfItems The amount of said item we are looking for
     */
    public Sale enterItem(Integer itemId, Integer amountOfItems) throws ItemNotFoundException, DatabaseFailureException {
        Item searchedItem = externalInventorySystem.checkInventory(itemId, amountOfItems);
        sale.addItem(searchedItem);
        sale.updateRunningTotal();
        return sale;
    }

    /**
     * Applies discount requested by customer
     *
     * @param customerId the id to be checked for discount level.
     */
    public Double discountRequest(Integer customerId) {
        discount = discountCatalog.calculateDiscount(customerId, sale);
        sale.applyDiscount(discount);
        return sale.getTotal();
    }

    /**
     * ends the sale, confirming items scanned in sale
     */
    public Double endSale() {
        return sale.getTotal();
    }

    /**
     * Receives payment to confirm the sale before returning the due change
     *
     * @param amount the amount used to pay with
     * @return the calculated amount of change that we are due
     */
    public Double makePayment(Double amount) {
        Payment payment = new Payment(amount);
        confirmSale(payment);
        return register.calculateChange(payment, sale);
    }

    /**
     * Confirms the sale by passing the parameter payment into the sale object, creating the now
     * confirmed saleInformation. SaleInformation is then sent to necessary external systems and
     * sent away for printing.
     *
     * @param payment the confirmed received payment
     */
    private void confirmSale(Payment payment) {
        SaleInformation saleInformation = sale.pay(payment);
        Receipt receipt = new Receipt(saleInformation);
        //printer.printReceipt(receipt);
        externalAccountingSystem.logSale(saleInformation);
        externalInventorySystem.updateInventory(saleInformation);
    }


    /**
     * creates a new sale object
     */
    public void makeNewSale() {
        sale = new Sale();
        sale.addObservers(saleObservers);
    }

    /**
     * adds observer to list of observers
     *
     * @param observer the observer to add to list of observers
     */
    public void addSaleObserver(SaleObserver observer) {
        saleObservers.add(observer);
    }
}

