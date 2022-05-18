package ee.bcs.java.controller;

public class TransactionsDto {
    private String transactionType;
    private String sender;
    private String receiver;
    private double amount;
    private double senderBalLeft;
    private double receiverBalLeft;

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getSenderBalLeft() {
        return senderBalLeft;
    }

    public void setSenderBalLeft(double senderBalLeft) {
        this.senderBalLeft = senderBalLeft;
    }

    public double getReceiverBalLeft() {
        return receiverBalLeft;
    }

    public void setReceiverBalLeft(double receiverBalLeft) {
        this.receiverBalLeft = receiverBalLeft;
    }
}
