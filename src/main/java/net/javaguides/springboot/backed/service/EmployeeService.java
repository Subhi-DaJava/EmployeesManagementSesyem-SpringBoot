package net.javaguides.springboot.backed.service;

import net.javaguides.springboot.backed.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
}
