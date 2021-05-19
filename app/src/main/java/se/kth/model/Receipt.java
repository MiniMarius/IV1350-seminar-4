package se.kth.model;

/**
 * Stores instance of SaleInformation to be sent to printer for printing
 */
public class Receipt {
    private SaleInformation saleInformation;

    public Receipt(SaleInformation saleInformation) {
        this.saleInformation = saleInformation;
    }

    @Override
    public String toString() {
        return "Printing Receipt:" + "\n" + saleInformation;
    }
}
