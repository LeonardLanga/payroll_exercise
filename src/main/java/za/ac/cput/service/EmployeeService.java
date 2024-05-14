package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.ContactRepository;
import za.ac.cput.repository.EmployeeRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService{

    public ContactRepository contactRepository;
    public EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService(ContactRepository contactRepository, EmployeeRepository employeeRepository){
        this.contactRepository = contactRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        contactRepository.save(employee.getContact());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee read(Long employeeNumber) {
        return employeeRepository.findById(employeeNumber).orElse(null);
    }

    @Override
    public Employee update(Employee employee) {
        contactRepository.save(employee.getContact());
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long employeeNumber) {
        employeeRepository.deleteById(employeeNumber);
    }

    @Override
    public Set<Employee> getAll() {
        return employeeRepository.findAll().stream().collect(Collectors.toSet());
    }
}
