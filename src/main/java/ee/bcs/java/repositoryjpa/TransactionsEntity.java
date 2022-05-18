package ee.bcs.java.repositoryjpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "transactions")
public class TransactionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String transactionType;
    private Double amount;
    private Double senderBalLeft;
    private Double receiverBalLeft;

    @ManyToOne
    @JoinColumn(name = "receiver")
    private BankAccountEntity receiver;

    @ManyToOne
    @JoinColumn(name = "sender")
    private BankAccountEntity sender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getSenderBalLeft() {
        return senderBalLeft;
    }

    public void setSenderBalLeft(Double senderBalLeft) {
        this.senderBalLeft = senderBalLeft;
    }

    public Double getReceiverBalLeft() {
        return receiverBalLeft;
    }

    public void setReceiverBalLeft(Double receiverBalLeft) {
        this.receiverBalLeft = receiverBalLeft;
    }

    public BankAccountEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(BankAccountEntity receiver) {
        this.receiver = receiver;
    }

    public BankAccountEntity getSender() {
        return sender;
    }

    public void setSender(BankAccountEntity sender) {
        this.sender = sender;
    }
}
