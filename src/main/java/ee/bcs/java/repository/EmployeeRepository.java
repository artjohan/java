package ee.bcs.java.repository;


import ee.bcs.java.controller.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<EmployeeDto> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EmployeeDto.class));
    }public EmployeeDto getEmployee(int n) {
        String sql = "SELECT * FROM employee WHERE id = :n";
        Map paramMap = new HashMap();
        paramMap.put("n", n);
        return jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(EmployeeDto.class));
    }
    public void saveEmployee(EmployeeDto employee) {
        String sql = "INSERT INTO employee (first_name, last_name, age) VALUES (:fName, :lName, :n)";
        Map paramMap = new HashMap();
        paramMap.put("fName", employee.getFirstName());
        paramMap.put("lName", employee.getLastName());
        paramMap.put("n", employee.getAge());
        jdbcTemplate.update(sql, paramMap);
    }
    public void setEmployee(EmployeeDto employee, int n) {
        String sql = "UPDATE employee SET first_name = :fName, last_name = :lName WHERE id = :n";
        Map paramMap = new HashMap();
        paramMap.put("n", n);
        paramMap.put("fName", employee.getFirstName());
        paramMap.put("lName", employee.getLastName());
        jdbcTemplate.update(sql, paramMap);
    }
    public void deleteEmployee(int n) {
        String sql = "DELETE FROM employee WHERE id = :n";
        Map paramMap = new HashMap();
        paramMap.put("n", n);
        jdbcTemplate.update(sql, paramMap);
    }
    public void setEmployeeAge(EmployeeDto employee, int n) {
        String sql = "UPDATE employee SET age = :age WHERE id = :n";
        Map paramMap = new HashMap();
        paramMap.put("n", n);
        paramMap.put("age", employee.getAge());
        jdbcTemplate.update(sql, paramMap);
    }
}
