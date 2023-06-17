package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.Employee;
import qlks.java.qlks_javaweb.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> GetAll() {
        return employeeRepository.findAll();
    }

    public void add(Employee newEmployee) {
        employeeRepository.save(newEmployee);
    }

    public Employee get(long id) {
        return employeeRepository.findById(id).stream().findFirst().orElse(null);
    }

    public Employee getEmployeeById(long id){
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw  new RuntimeException("Employee not found for id :: " + id);
        } return employee;
    }


    public Employee updateEmployee(Employee updatedEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(updatedEmployee.getMaNV());
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setTenNV(updatedEmployee.getTenNV());
            employee.setCccd(updatedEmployee.getCccd());
            employee.setNgaySinh(updatedEmployee.getNgaySinh());
            employee.setGioiTinh(updatedEmployee.getGioiTinh());
            employee.setAddress(updatedEmployee.getAddress());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
            employee.setLuong(updatedEmployee.getLuong());
            employee.setSection(updatedEmployee.getSection());
            // You can update other fields as needed

            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(Long maNV) {
        employeeRepository.deleteById(maNV);
    }
}
