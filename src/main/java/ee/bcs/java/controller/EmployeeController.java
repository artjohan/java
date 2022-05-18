package ee.bcs.java.controller;

import ee.bcs.java.repositoryjpa.EmployeeEntity;
import ee.bcs.java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employee/name/{name}")
    public List<EmployeeEntity> getAllEmployees(@PathVariable String name) {
        return employeeService.getAllEmployees(name);
    }
    @GetMapping("employee/{n}")
    public EmployeeDto getEmployee(@PathVariable int n) {
        return employeeService.getEmployee(n);
    }
    @PostMapping("employee")
    public void saveEmployee(@RequestBody EmployeeDto employee) {
        employeeService.saveEmployee(employee);
    }
    @PutMapping("employee/{n}")
    public void setEmployee(@RequestBody EmployeeDto employee, @PathVariable int n) {
        employeeService.setEmployee(employee, n);
    }
    @DeleteMapping("employee/{n}")
    public void deleteEmployee(@PathVariable int n) {
       employeeService.deleteEmployee(n);
    }
    @PutMapping("employee/{n}/age")
    public void setEmployeeAge(@RequestBody EmployeeDto employee, @PathVariable int n) {
        employeeService.setEmployeeAge(employee, n);
    }
}
