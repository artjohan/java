package ee.bcs.java.service;

import ee.bcs.java.controller.BankAccountDto;
import ee.bcs.java.controller.BankAccountNameDto;
import ee.bcs.java.controller.TransactionsDto;
import ee.bcs.java.repository.AccountRepository;
import ee.bcs.java.repositoryjpa.*;
import liquibase.pro.packaged.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class BankService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionsRepositoryJpa transactionsRepositoryJpa;

    @Autowired
    private BankAccountRepositoryJpa bankAccountRepositoryJpa;

    public void createAccount(BankAccountDto account) {
        BankAccountEntity bankAccount = new BankAccountEntity();
        bankAccount.setAccNr(account.getAccNr());
        bankAccount.setFirstName(account.getFirstName());
        bankAccount.setLastName(account.getLastName());
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(account.getEmployeeId());
        bankAccount.setEmployee(employee);
        bankAccount.setBalance(0.0);
        bankAccountRepositoryJpa.save(bankAccount);
    }

    public double getBalance(String accNr) {
        return bankAccountRepositoryJpa.findByAccNr(accNr).getBalance();
    }

    public List<BankAccountEntity> getInfo(String accNr) {
        return bankAccountRepositoryJpa.findAllByAccNr(accNr);
    }

    public String depositMoney(String accNr, double amount) {
        BankAccountEntity acc = bankAccountRepositoryJpa.findByAccNr(accNr);
        if (acc.isLocked()) {
            return "Konto on lukus";
        }
        if (amount <= 0) {
            return "Summa peab olema positiivne";
        }
        acc.setBalance(acc.getBalance() + amount);
        TransactionsEntity transaction = new TransactionsEntity();
        transaction.setTransactionType("DEPOSIT");
        transaction.setAmount(amount);
        BankAccountEntity bankAccount = new BankAccountEntity();
        bankAccount.setAccNr(accNr);
        transaction.setReceiver(bankAccount);
        transaction.setReceiverBalLeft(acc.getBalance());
        transaction.setSender(null);
        transaction.setSenderBalLeft(0.0);
        transactionsRepositoryJpa.save(transaction);
        return "Raha on edukalt sisestatud\nKonto balanss: " + acc.getBalance();
    }

    public String withdrawMoney(String accNr, double amount) {
        BankAccountEntity acc = bankAccountRepositoryJpa.findByAccNr(accNr);
        if (acc.isLocked()) {
            return "Konto on lukus";
        }
        if (amount <= 0) {
            return "Summa peab olema positiivne";
        }
        if (acc.getBalance() <= amount) {
            return "Kontol pole piisavalt raha";
        }
        acc.setBalance(acc.getBalance() - amount);
        TransactionsEntity transaction = new TransactionsEntity();
        transaction.setTransactionType("WITHDRAW");
        transaction.setAmount(amount);
        BankAccountEntity bankAccount = new BankAccountEntity();
        bankAccount.setAccNr(accNr);
        transaction.setReceiver(bankAccount);
        transaction.setReceiverBalLeft(acc.getBalance());
        transaction.setSender(null);
        transaction.setSenderBalLeft(0.0);
        transactionsRepositoryJpa.save(transaction);
        return "Raha on edukalt välja võetud\nKonto balanss: " + acc.getBalance();
    }

    @Transactional
    public String transferMoney(String fromAcc, String toAcc, double amount) {
        BankAccountEntity toAccount = bankAccountRepositoryJpa.findByAccNr(toAcc);
        BankAccountEntity fromAccount = bankAccountRepositoryJpa.findByAccNr(fromAcc);
        if (toAccount.isLocked() || fromAccount.isLocked()) {
            return "Vähemalt üks kontodest onto on lukus";
        }
        if (amount < 0) {
            return "Summa peab olema positiivne";
        }
        if (fromAccount.getBalance() <= amount) {
            return "Kontol pole piisavalt raha";
        }
        toAccount.setBalance(toAccount.getBalance() + amount);
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        TransactionsEntity transaction = new TransactionsEntity();
        transaction.setTransactionType("TRANSFER");
        transaction.setAmount(amount);
        BankAccountEntity bankAccountTo = new BankAccountEntity();
        bankAccountTo.setAccNr(toAcc);
        BankAccountEntity bankAccountFrom = new BankAccountEntity();
        bankAccountFrom.setAccNr(fromAcc);
        transaction.setReceiver(bankAccountTo);
        transaction.setReceiverBalLeft(toAccount.getBalance());
        transaction.setSender(bankAccountFrom);
        transaction.setSenderBalLeft(fromAccount.getBalance());
        transactionsRepositoryJpa.save(transaction);
        return "Raha on edukalt üle kantud\nSaatja konto balanss: " +
                fromAccount.getBalance() + "\nSaaja konto balanss: " + toAccount.getBalance();
    }

    public String lockAccount(String accNr) {
        bankAccountRepositoryJpa.findByAccNr(accNr).setLocked(true);
        return "Konto on nüüd lukus";
    }

    public String unlockAccount(String accNr) {
        bankAccountRepositoryJpa.findByAccNr(accNr).setLocked(false);
        return "Konto on nüüd avatud";
    }

    public void deleteAccount(String accNr) {
        bankAccountRepositoryJpa.deleteAllByAccNr(accNr);
    }

    public List<TransactionsEntity> getTransactions(String accNr) {
        List<TransactionsEntity> transactions = new ArrayList<>(transactionsRepositoryJpa.findAllByReceiverOrSender(accNr, accNr));
        return transactions;
    }

    public List<TransactionsDto> getEmployeeTransactions(Integer id) {

        List<TransactionsEntity> transactionsEntities = transactionsRepositoryJpa.findAllByReceiver_Employee_IdOrSender_Employee_Id(id, id);
        List<TransactionsDto> transactions = new ArrayList<>();

        for (TransactionsEntity transaction : transactionsEntities) {
            TransactionsDto transactionsDto = new TransactionsDto();
            transactionsDto.setTransactionType(transaction.getTransactionType());
            transactionsDto.setAmount(transaction.getAmount());
            transactionsDto.setReceiver(transaction.getReceiver().getAccNr());
            if (transaction.getSender() == null) {
                transactionsDto.setSender(null);
            }
            else {
                transactionsDto.setSender(transaction.getSender().getAccNr());
            }
            transactionsDto.setReceiverBalLeft(transaction.getReceiverBalLeft());
            transactionsDto.setSenderBalLeft(transaction.getSenderBalLeft());
            transactions.add(transactionsDto);
        }
        return transactions;
    }

    public List<BankAccountNameDto> getNrBal(String fName, String lName) {
        return accountRepository.getNrBal(fName, lName);
    }

    public List<TransactionsDto> getNameTransactions(String fName, String lName) {
        return accountRepository.getNameTransactions(fName, lName);
    }
}
