package psa.soporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import psa.soporte.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}