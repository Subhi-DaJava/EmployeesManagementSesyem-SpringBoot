package net.javaguides.springboot.backed.controller;

import net.javaguides.springboot.backed.model.Employee;
import net.javaguides.springboot.backed.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/api/employees") //base url
public class EmployeeController {
    //Injecte dépendance, pas besoin d'annoter @Autowired

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //build create employee REST Api
    //ResponseEntity is generic class, we can provide the details, Header etc
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    //build get all employees REST Api
    @GetMapping()
    public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }
    //build get Employee by ID REST Api
    //http://localhost:9088/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){

        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }
    //Build Update REST Api
    //http://localhost:9088/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
                                                  ,@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }
    //Build Delete Employee REST Api
    //http://localhost:9088/api/employees/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        //delete employee from DB
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }

}
