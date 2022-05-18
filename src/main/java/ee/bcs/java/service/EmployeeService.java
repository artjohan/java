package ee.bcs.java.service;

import ee.bcs.java.controller.BankAccountDto;
import ee.bcs.java.controller.EmployeeDto;
import ee.bcs.java.repository.EmployeeRepository;
import ee.bcs.java.repository.EmployeeRepository;
import ee.bcs.java.repositoryjpa.BankAccountEntity;
import ee.bcs.java.repositoryjpa.EmployeeEntity;
import ee.bcs.java.repositoryjpa.EmployeeRepositoryJpa;
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
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeRepositoryJpa employeeRepositoryJpa;

    public List<EmployeeEntity> getAllEmployees(String name) {
        return employeeRepositoryJpa.findAllByFirstNameContainingIgnoreCase(name);
    }
    public EmployeeDto getEmployee(int n) {
        EmployeeEntity employee = employeeRepositoryJpa.getOne(n);

        EmployeeDto result = new EmployeeDto();
        result.setId(employee.getId());
        result.setFirstName(employee.getFirstName());
        result.setLastName(employee.getLastName());
        result.setAge(employee.getAge());
        List<BankAccountDto> accounts = new ArrayList<>();

        for (BankAccountEntity account : employee.getAccounts()) {
            BankAccountDto accountDto = new BankAccountDto();
            accountDto.setAccNr(account.getAccNr());
            accountDto.setBalance(account.getBalance());
            accountDto.setFirstName(account.getFirstName());
            accountDto.setLastName(account.getLastName());
            accountDto.setLocked(account.isLocked());
            accountDto.setEmployeeId(account.getEmployee().getId());
            accounts.add(accountDto);
        }

        result.setAccount(accounts);

        return result;
    }
    public void saveEmployee(EmployeeDto employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setAge(employee.getAge());
        employeeRepositoryJpa.save(employeeEntity);
    }
    public void setEmployee(EmployeeDto employee, int n) {
        EmployeeEntity employeeEntity = employeeRepositoryJpa.getOne(n);
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setAge(employee.getAge());
        employeeRepository.setEmployee(employee, n);
    }
    public void deleteEmployee(int n) {
        employeeRepositoryJpa.deleteById(n);
    }
    public void setEmployeeAge(EmployeeDto employee, int n) {
        EmployeeEntity employeeEntity = employeeRepositoryJpa.getOne(n);
        employeeEntity.setAge(employee.getAge());
        employeeRepositoryJpa.save(employeeEntity);
    }
}
