package qlks.java.qlks_javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlks.java.qlks_javaweb.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
