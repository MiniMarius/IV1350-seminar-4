package se.kth.view;

import se.kth.model.SaleObserver;

/**
 * responsible for showing total revenue since program's start
 */
public class TotalRevenueView implements SaleObserver {
    private Double revenue;

    /**
     * creates new instance with revenue counter set to zero
     */
    public TotalRevenueView() {
        revenue = 0.0;
    }

    /**
     * adds the payment for sale as attribute and prints the current revenue
     * to user interface
     *
     * @param amount the amount of completed sale
     */
    @Override
    public void updateRevenue(Double amount) {
        revenue += amount;
        printRevenue();
    }

    /**
     * prints the current revenue
     */
    private void printRevenue() {
        System.out.println("\nTotal revenue: " + revenue);
    }
}
