package ee.bcs.java.repository;

import ee.bcs.java.controller.BankAccountDto;
import ee.bcs.java.controller.BankAccountNameDto;
import ee.bcs.java.controller.TransactionsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(BankAccountDto accNr) {
        String sql = "INSERT INTO bankaccounts (acc_nr, first_name, last_name, employee_id) VALUES (:accNr, :fName, :lName, :employeeId)";
        Map paramMap = new HashMap();
        paramMap.put("accNr", accNr.getAccNr());
        paramMap.put("fName", accNr.getFirstName());
        paramMap.put("lName", accNr.getLastName());
        paramMap.put("employeeId", accNr.getEmployeeId());
        jdbcTemplate.update(sql, paramMap);
    }
    public double getBalance(String accNr) {
        String sql = "SELECT balance FROM bankaccounts WHERE acc_nr = :accNr";
        Map paramMap = new HashMap();
        paramMap.put("accNr", accNr);
        return jdbcTemplate.queryForObject(sql, paramMap, double.class);
    }
    public BankAccountDto getInfo(String accNr) {
        String sql = "SELECT * FROM bankaccounts WHERE acc_nr = :accNr";
        Map paramMap = new HashMap();
        paramMap.put("accNr", accNr);
        return jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(BankAccountDto.class));
    }
    public boolean isLocked(String accNr) {
        String locked = "SELECT is_locked FROM bankaccounts WHERE acc_nr = :accNr";
        Map paramMapLocked = new HashMap();
        paramMapLocked.put("accNr", accNr);
        return  jdbcTemplate.queryForObject(locked, paramMapLocked, boolean.class);
    }
    public void deposit(String accNr, double amount) {
        String sql = "UPDATE bankaccounts SET balance = balance + :amount WHERE acc_nr = :accNr";
        Map paramMap = new HashMap();
        paramMap.put("amount", amount);
        paramMap.put("accNr", accNr);
        jdbcTemplate.update(sql, paramMap);
    }
    public void transactionDeposit(String accNr, double amount) {
        String transaction = "INSERT INTO transactions (amount, transaction_type, receiver," +
                " receiver_bal_left) VALUES (:amount, 'DEPOSIT', :accNr, :balance)";
        Map paramMapTransaction = new HashMap();
        paramMapTransaction.put("amount", amount);
        paramMapTransaction.put("accNr", accNr);
        paramMapTransaction.put("balance", getBalance(accNr));
        jdbcTemplate.update(transaction, paramMapTransaction);
    }
    public void withdraw(String accNr, double amount) {
        String sql = "UPDATE bankaccounts SET balance = balance - :amount WHERE acc_nr = :accNr";
        Map paramMap = new HashMap();
        paramMap.put("amount", amount);
        paramMap.put("accNr", accNr);
        jdbcTemplate.update(sql, paramMap);
    }
    public void transactionWithdraw(String accNr, double amount) {
        String transaction = "INSERT INTO transactions (amount, transaction_type, receiver," +
                " receiver_bal_left) VALUES (:amount, 'WITHDRAWAL', :accNr, :balance)";
        Map paramMapTransaction = new HashMap();
        paramMapTransaction.put("amount", amount);
        paramMapTransaction.put("accNr", accNr);
        paramMapTransaction.put("balance", getBalance(accNr));
        jdbcTemplate.update(transaction, paramMapTransaction);
    }
    public void transactionTransfer(String fromAcc, String toAcc, double amount) {
        String transaction = "INSERT INTO transactions (amount, transaction_type, sender, " +
                "receiver, receiver_bal_left, sender_bal_left) " +
                "VALUES (:amount, 'TRANSFER', :fromAcc, :toAcc, :balanceTo, :balanceFrom)";
        Map paramMapTransaction = new HashMap();
        paramMapTransaction.put("amount", amount);
        paramMapTransaction.put("fromAcc", fromAcc);
        paramMapTransaction.put("toAcc", toAcc);
        paramMapTransaction.put("balanceTo", getBalance(toAcc));
        paramMapTransaction.put("balanceFrom", getBalance(fromAcc));
        jdbcTemplate.update(transaction, paramMapTransaction);
    }
    public void lockAccount(String accNr) {
        String sql = "UPDATE bankaccounts SET is_locked = TRUE WHERE acc_nr = :accNr";
        Map paramMap = new HashMap();
        paramMap.put("accNr", accNr);
        jdbcTemplate.update(sql, paramMap);
    }
    public void unlockAccount(String accNr) {
        String sql = "UPDATE bankaccounts SET is_locked = FALSE WHERE acc_nr = :accNr";
        Map paramMap = new HashMap();
        paramMap.put("accNr", accNr);
        jdbcTemplate.update(sql, paramMap);
    }
    public void deleteAccount(String accNr) {
        String sql = "DELETE FROM bankaccounts WHERE acc_nr = :accNr";
        Map paramMap = new HashMap();
        paramMap.put("accNr", accNr);
        jdbcTemplate.update(sql, paramMap);
    }
    public List<TransactionsDto> getTransactions(String accNr) {
        String sql = "SELECT * FROM transactions WHERE receiver = :accNr OR sender = :accNr";
        Map paramMap = new HashMap();
        paramMap.put("accNr", accNr);
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(TransactionsDto.class));
    }
    public List<TransactionsDto> getEmployeeTransactions(Integer id) {
        String sql = "SELECT t.* FROM transactions t JOIN bankaccounts b ON t.receiver = b.acc_nr OR t.sender = b.acc_nr WHERE b.employee_id = :id";
        Map paramMap = new HashMap();
        paramMap.put("id", id);
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(TransactionsDto.class));
    }
    public List<BankAccountNameDto> getNrBal(String fName, String lName) {
        String sql = "SELECT b.acc_nr, b.balance FROM bankaccounts b JOIN employee e ON b.employee_id = e.id " +
                "WHERE e.first_name = :fName AND e.last_name = :lName";
        Map paramMap = new HashMap();
        paramMap.put("fName", fName);
        paramMap.put("lName", lName);
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(BankAccountNameDto.class));
    }
    public List<TransactionsDto> getNameTransactions(String fName, String lName) {
        String sql = "SELECT t.* FROM transactions t JOIN bankaccounts b on t.receiver = b.acc_nr OR t.sender = b.acc_nr" +
                " JOIN employee e on b.employee_id = e.id WHERE e.first_name = :fName AND e.last_name = :lName;";
        Map paramMap = new HashMap();
        paramMap.put("fName", fName);
        paramMap.put("lName", lName);
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(TransactionsDto.class));
    }
}
