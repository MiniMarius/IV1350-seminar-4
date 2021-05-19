package se.kth.model;

public interface SaleObserver {

    /**
     * Notifies the observers of the amount when payment has been received
     * in SaleInformation class
     *
     * @param amount the amount of completed sale
     */
    void updateRevenue(Double amount);
}
