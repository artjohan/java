package ee.bcs.java.repositoryjpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="bankaccounts")
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String accNr;
    private String firstName;
    private String lastName;
    private boolean isLocked;
    private Double balance;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private EmployeeEntity employee;

    @OneToMany(mappedBy = "receiver")
    private List<TransactionsEntity> receiverTransactions;

    @OneToMany(mappedBy = "sender")
    private List<TransactionsEntity> senderTransactions;

    public String getAccNr() {
        return accNr;
    }

    public void setAccNr(String accNr) {
        this.accNr = accNr;
    }

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

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public List<TransactionsEntity> getReceiverTransactions() {
        return receiverTransactions;
    }

    public void setReceiverTransactions(List<TransactionsEntity> receiverTransactions) {
        this.receiverTransactions = receiverTransactions;
    }

    public List<TransactionsEntity> getSenderTransactions() {
        return senderTransactions;
    }

    public void setSenderTransactions(List<TransactionsEntity> senderTransactions) {
        this.senderTransactions = senderTransactions;
    }
}
