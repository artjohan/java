package ee.bcs.java.controller;

import ee.bcs.java.repositoryjpa.BankAccountEntity;
import ee.bcs.java.repositoryjpa.TransactionsEntity;
import ee.bcs.java.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/bank/account")
    public void createAccount(@RequestBody BankAccountDto account) {
       bankService.createAccount(account);
    }
    @GetMapping("/bank/account/{accNr}")
    public double getBalance(@PathVariable String accNr) {
        return bankService.getBalance(accNr);
    }
    @GetMapping("/bank/account/info/{accNr}")
    public List<BankAccountEntity> getInfo(@PathVariable String accNr) {
       return bankService.getInfo(accNr);
    }
    @PutMapping("/bank/account/deposit/{accNr}")
    public String depositMoney(@PathVariable String accNr, @RequestBody double amount) {
        return bankService.depositMoney(accNr, amount);
    }
    @PutMapping("/bank/account/withdraw/{accNr}")
    public String withdrawMoney(@PathVariable String accNr, @RequestBody double amount) {
        return bankService.withdrawMoney(accNr, amount);
    }
    @PutMapping("/bank/account/transfer/{fromAcc}/{toAcc}")
    public String transferMoney(@PathVariable String fromAcc, @PathVariable String toAcc, @RequestBody double amount) {
        return bankService.transferMoney(fromAcc, toAcc, amount);
    }
    @GetMapping("/bank/account/lock/{accNr}")
    public String lockAccount(@PathVariable String accNr) {
       return bankService.lockAccount(accNr);
    }
    @GetMapping("/bank/account/unlock/{accNr}")
    public String unlockAccount(@PathVariable String accNr) {
        return bankService.unlockAccount(accNr);
    }
    @DeleteMapping("bank/account/delete/{accNr}")
    public void deleteAccount(@PathVariable String accNr) {
        bankService.deleteAccount(accNr);
    }
    @GetMapping("bank/account/transactions/{accNr}")
    public List<TransactionsEntity> getTransactions(@PathVariable String accNr) {
        return bankService.getTransactions(accNr);
    }
    @GetMapping("bank/account/transactions/employee/{id}")
    public List<TransactionsDto> getEmployeeTransactions(@PathVariable Integer id) {
        return bankService.getEmployeeTransactions(id);
    }
    @GetMapping("bank/account/employee/name/{fName}/{lName}")
    public List<BankAccountNameDto> getNrBal(@PathVariable String fName, @PathVariable String lName) {
        return bankService.getNrBal(fName, lName);
    }
    @GetMapping("bank/account/transactions/name/{fName}/{lName}")
    public List<TransactionsDto> getNameTransactions(@PathVariable String fName, @PathVariable String lName) {
        return bankService.getNameTransactions(fName, lName);
    }
}
