package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Contains the info of a bank
 * @author  Joseph Josue Forestal
 */
public class Bank {
    String name;
    String branch;
    double revenue;
    String address;
    int noOfCustomers;

    /***
     * Constructor
     * @param name name of the bank
     * @param branch branch of the bank
     * @param revenue revenue of the bank
     * @param address address of the bank
     * @param noOfCustomers number of customers of the bank
     */
    public Bank(String name, String branch, double revenue, String address, int noOfCustomers) {
        this.name = name;
        this.branch = branch;
        this.revenue = revenue;
        this.address = address;
        this.noOfCustomers = noOfCustomers;
    }

    /**
     * Get the name of the bank
     * @return the name of the bank
     */
    public String getName() {
        return name;
    }
    /**
     * Get the branch of the bank
     * @return the branch of the bank
     */
    public String getBranch() {
        return branch;
    }
    /**
     * Get the revenue of the bank
     * @return the revenue of the bank
     */
    public double getRevenue() {
        return revenue;
    }
    /**
     * Get the address of the bank
     * @return the address of the bank
     */
    public String getAddress() {
        return address;
    }
    /**
     * Get the number of customers of the bank
     * @return the number of customers of the bank
     */
    public int getNoOfCustomers() {
        return noOfCustomers;
    }

    /***
     * Set te name of the bank
     * @param name the name that is being set
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * Set the branch of the bank
     * @param branch   that is being set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /***
     * Set the revenue of the bank
     * @param revenue the name that is being set
     */
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    /***
     * Set the address of the bank
     * @param address the name that is being set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /***
     * Set the number of customers of the bank
     * @param noOfCustomers  the number of customers that is being set
     */
    public void setNoOfCustomers(int noOfCustomers) {
        this.noOfCustomers = noOfCustomers;
    }

    public static void main(String[] args) {
        ArrayList<Bank> banks = new ArrayList<Bank>();

        banks.add(new Bank("Td", "St-Michel", 740000, "5043", 230));
        banks.add(new Bank("Td", "CDG", 603000, "5043", 205));
        banks.add(new Bank("Td", "StLaurent", 903000, "5043", 210));
        banks.add(new Bank("Td", "StMichel", 604000, "5043", 230));
        banks.add(new Bank("Td", "StMichel", 50300, "5043", 250));

        findBankOfParticularBranch(banks, "Rbc");

        banks.add(new Bank("RBC", "StMichel", 500000, "5043", 245));
        banks.add(new Bank("RBC", "StLaurent", 700000, "5043", 240));
        banks.add(new Bank("RBC", "STL", 605000, "5043", 200));
        banks.add(new Bank("RBC", "SLaurent", 56000, "5043", 236));
        banks.add(new Bank("RBC", "CDG", 500000, "5043", 215));

        displayBankThatMakeMoreRevenue(banks);

        displayNumberOfCustomerOfTheBanks(banks);

        countBank(banks);

    }

    /***
     * Find Bank of a particular branch based of the amount of money
     * @param banks the bank
     * @param bankName the bank name
     */
    public static void findBankOfParticularBranch(ArrayList<Bank> banks, String bankName) {
        if (bankName.equalsIgnoreCase("Td") || bankName.equalsIgnoreCase("Rbc")) {
            for (Bank bank : banks) {
                if ((bank.getRevenue() >= 600000 &&
                        bank.getRevenue() <= 700000)) {
                    System.out.println("Bank " + bank.getName() + " from " + bank.getBranch() + " . Make a revenue between 600K and 700k");
                }
            }
        }
    }

    /***
     * Count the number of banks of a bank
     * @param banks the bank that is being count
     */
    public static void countBank(ArrayList<Bank> banks) {
        int countTD = 0;
        int countRbc = 0;
        for (Bank bank : banks) {
            if (bank.getName().equalsIgnoreCase("Td")) countTD++;
            else if (bank.getName().equalsIgnoreCase("RBC")) countRbc++;
        }
        System.out.println("Td has " + countTD + " Banks.");

        System.out.println("Rbc has " + countRbc + " Banks.");
    }

    /***
     * Display the bank that make more revenue
     * @param banks the banks that we counting
     */
    public static void displayBankThatMakeMoreRevenue(ArrayList<Bank> banks) {
        int sumRBC = 0;
        int sumTD = 0;

        for (Bank bank : banks) {
            if (bank.getName().equalsIgnoreCase("RBc")) {
                sumRBC += bank.getRevenue();
            } else {
                sumTD += bank.getRevenue();
            }
        }
        if (sumRBC > sumTD) System.out.println("Bank RBC makes more revenue for a total of " + sumRBC + "$");
        else if (sumTD > sumRBC) System.out.println("Bank TD makes more revenue for a total of " + sumTD + "$");
        else System.out.println("They make the same amount of revenue " + sumTD + "$");
    }

    /***
     * Display the number of Customer of a bank
     * @param banks banks we want to display
     */
    public static void displayNumberOfCustomerOfTheBanks(ArrayList<Bank> banks) {
        int sumCustomerRbc = 0;
        int sumCustomerTD = 0;
        for (Bank bank : banks) {
            if (bank.getName().equalsIgnoreCase("RBc")) {
                sumCustomerRbc += bank.getNoOfCustomers();
            } else {
                sumCustomerTD += bank.getNoOfCustomers();
            }
        }
        System.out.println("Bank RBC  have a total of " + sumCustomerRbc );
        System.out.println("Bank TD have a total of " + sumCustomerTD);
    }
}
