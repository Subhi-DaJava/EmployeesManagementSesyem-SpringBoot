package net.javaguides.springboot.backed.service.impl;

import net.javaguides.springboot.backed.exception.ResourceNotFoundException;
import net.javaguides.springboot.backed.model.Employee;
import net.javaguides.springboot.backed.repository.EmployeeRepository;
import net.javaguides.springboot.backed.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
       /* Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else {
            throw new ResourceNotFoundException("Employee","Id",id);
        }*/
        //Pareille avec l'expression Lambda
        return employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
    }
}
