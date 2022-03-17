package net.javaguides.springboot.backed.repository;

import net.javaguides.springboot.backed.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//pas besoin de rajouter @Repository sur EmployeeRepository classe
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
