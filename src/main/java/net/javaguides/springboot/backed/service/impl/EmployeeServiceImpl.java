package net.javaguides.springboot.backed.service.impl;

import net.javaguides.springboot.backed.model.Employee;
import net.javaguides.springboot.backed.repository.EmployeeRepository;
import net.javaguides.springboot.backed.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //Spring Boot automatically autowired cette classe
    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
