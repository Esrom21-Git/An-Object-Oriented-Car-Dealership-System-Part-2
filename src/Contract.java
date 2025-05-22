package com.yearup.dealership;

/**
 * Abstract class representing a vehicle contract
 * Contains common fields and methods for all contract types
 */
public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;

    /**
     * Constructor for Contract class
     * @param date Date of the contract
     * @param customerName Name of the customer
     * @param customerEmail Email of the customer
     * @param vehicle Vehicle being sold or leased
     */
    public Contract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Abstract method to calculate the total price of the contract
     * @return the total price
     */
    public abstract double getTotalPrice();

    /**
     * Abstract method to calculate the monthly payment
     * @return the monthly payment amount
     */
    public abstract double getMonthlyPayment();
}