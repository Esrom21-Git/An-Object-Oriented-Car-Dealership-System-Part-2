package com.yearup.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class responsible for managing contract data persistence
 */
public class ContractFileManager {
    private String contractsFilePath;

    /**
     * Constructor for ContractFileManager
     * @param contractsFilePath path to the contracts data file
     */
    public ContractFileManager(String contractsFilePath) {
        this.contractsFilePath = contractsFilePath;
    }

    /**
     * Saves a contract to the contracts file
     * Appends the contract data to the existing file
     * @param contract the contract to save
     * @return true if successful, false otherwise
     */
    public boolean saveContract(Contract contract) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(contractsFilePath, true)))) {
            // Write contract data to the file by using the toString method
            writer.println(contract.toString());
            return true;
        } catch (IOException e) {
            System.err.println("Error saving contract: " + e.getMessage());
            return false;
        }
    }
}
