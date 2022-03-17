package net.javaguides.springboot.backed.controller;

import net.javaguides.springboot.backed.model.Employee;
import net.javaguides.springboot.backed.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/api/employees") //base url
public class EmployeeController {
    //Injecte dépendance, pas besoin d'annoter @Autowired

    private EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //build create employee REST Api
    //ResponseEntity is generic class, we can provide the details, Header etc
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

}
