package ee.bcs.java.controller;

import java.util.List;

public class BankAccountDto {
    private String accNr;
    private String firstName;
    private String lastName;
    private double balance;
    private boolean isLocked;
    private int employeeId;
    private List<TransactionsDto> transactions;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccNr() {
        return accNr;
    }

    public void setAccNr(String accNr) {
        this.accNr = accNr;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<TransactionsDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionsDto> transactions) {
        this.transactions = transactions;
    }
}
