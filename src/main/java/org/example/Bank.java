package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bank {
    String name;
    String branch;
    double revenue;
    String address;
    int noOfCustomers;

    public Bank(String name, String branch, double revenue, String address, int noOfCustomers) {
        this.name = name;
        this.branch = branch;
        this.revenue = revenue;
        this.address = address;
        this.noOfCustomers = noOfCustomers;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public double getRevenue() {
        return revenue;
    }

    public String getAddress() {
        return address;
    }

    public int getNoOfCustomers() {
        return noOfCustomers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setNoOfCustomers(int noOfCustomers) {
        this.noOfCustomers = noOfCustomers;
    }

    public static void main(String[] args) {
        ArrayList<Bank> banks = new ArrayList<Bank>();

        banks.add(new Bank("Td","St-Michel",740000,"5043",230));
        banks.add(new Bank("Td","CDG",603000,"5043",205));
        banks.add(new Bank("Td","StLaurent",903000,"5043",210));
        banks.add(new Bank("Td","StMichel",604000,"5043",230));
        banks.add(new Bank("Td","StMichel",50300,"5043",250));

        findBankOfParticularBranch(banks,"Rbc");

        banks.add(new Bank("RBC","StMichel",500000,"5043",245));
        banks.add(new Bank("RBC","StLaurent",700000,"5043",240));
        banks.add(new Bank("RBC","STL",605000,"5043",200));
        banks.add(new Bank("RBC","SLaurent",56000,"5043",236));
        banks.add(new Bank("RBC","CDG",500000,"5043",215));

        displayBankThatMakeMoreRevenue(banks);

    }

    public static void findBankOfParticularBranch( ArrayList<Bank> banks, String bankName) {
        if (bankName.equalsIgnoreCase("Td") || bankName.equalsIgnoreCase("Rbc")) {
            for (Bank bank : banks) {
                if ((bank.getRevenue() >= 600000 &&
                        bank.getRevenue() <= 700000)) {
                    System.out.println("Bank " + bank.getName() + " from " + bank.getBranch() + " . Make a revenue between 600K and 700k");
                }
            }
        }
    }
        public static void countBank(ArrayList<Bank> banks){
            int countTD = 0;
            int countRbc = 0;
            for(Bank bank : banks){
                if(bank.getName().equalsIgnoreCase("Td")) countTD++;
                else if (bank.getName().equalsIgnoreCase("RBC")) countRbc++;
            }
    }

    public static void displayBankThatMakeMoreRevenue(ArrayList<Bank> banks){
        int sumRBC = 0;
        int sumTD = 0;

        for(Bank bank: banks){
            if(bank.getName().equalsIgnoreCase("RBc")){
                sumRBC += bank.getRevenue();
            } else{
                sumTD += bank.getRevenue();
            }
        }
        if(sumRBC > sumTD) System.out.println("Bank RBC makes more revenue for a total of " + sumRBC +"$");
        else if (sumTD > sumRBC)System.out.println("Bank TD makes more revenue for a total of " + sumTD +"$");
        else System.out.println("They make the same amount of revenue " + sumTD + "$");
    }
}
