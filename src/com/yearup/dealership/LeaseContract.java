package com.yearup.dealership;

/**
 * Class representing a lease contract for vehicle leases
 * Extends abstract Contract class
 */
public class LeaseContract extends Contract {
    private static final double EXPECTED_END_VALUE_RATE = 0.50; // 50% of original price
    private static final double LEASE_FEE_RATE = 0.07; // 7% of original price
    private static final double LEASE_INTEREST_RATE = 0.04; // 4.0%
    private static final int LEASE_TERM_MONTHS = 36; // 36 months for all leases

    private double expectedEndingValue;
    private double leaseFee;

    /**
     * Constructor for LeaseContract
     * @param date Date of the contract
     * @param customerName Name of the customer
     * @param customerEmail Email of the customer
     * @param vehicle Vehicle being leased
     */
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
        this.expectedEndingValue = vehicle.getPrice() * EXPECTED_END_VALUE_RATE;
        this.leaseFee = vehicle.getPrice() * LEASE_FEE_RATE;
    }

    // Getters and setters
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    /**
     * Calculates total price for lease
     * Total = Vehicle Price - Expected End Value + Lease Fee
     * @return the total lease price
     */
    @Override
    public double getTotalPrice() {
        return getVehicle().getPrice() - expectedEndingValue + leaseFee;
    }

    /**
     * Calculates monthly payment for lease
     * Uses 4.0% interest rate for 36 months
     * @return the monthly payment amount
     */
    @Override
    public double getMonthlyPayment() {
        double loanAmount = getTotalPrice();

        // Monthly interest rate
        double monthlyRate = LEASE_INTEREST_RATE / 12;

        // Calculate monthly payment using loan formula
        return (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -LEASE_TERM_MONTHS));
    }

    /**
     * Returns a formatted string representation for saving to file
     * @return formatted string with all contract details
     */
    @Override
    public String toString() {
        return "LEASE|" + getDate() + "|" + getCustomerName() + "|" + getCustomerEmail() + "|" +
                getVehicle().getVin() + "|" + getVehicle().getYear() + "|" + getVehicle().getMake() + "|" +
                getVehicle().getModel() + "|" + getVehicle().getVehicleType() + "|" + getVehicle().getColor() + "|" +
                getVehicle().getOdometer() + "|" + getVehicle().getPrice() + "|" +
                getExpectedEndingValue() + "|" + getLeaseFee() + "|" +
                getTotalPrice() + "|" + getMonthlyPayment();
    }
}
