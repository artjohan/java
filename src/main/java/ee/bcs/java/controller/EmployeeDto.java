package ee.bcs.java.controller;

import java.util.List;

public class EmployeeDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer id;
    private List<BankAccountDto> account;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<BankAccountDto> getAccount() {
        return account;
    }

    public void setAccount(List<BankAccountDto> account) {
        this.account = account;
    }
}
