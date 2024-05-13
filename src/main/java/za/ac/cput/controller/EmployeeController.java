package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.demography.Contact;
import za.ac.cput.service.ContactService;
import za.ac.cput.service.EmployeeService;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{

    @Autowired
    private ContactService contactService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee)
    {
        contactService.create(employee.getContact());
        return employeeService.create(employee);
    }

    @GetMapping("/read/{employeeNumber}")
    public Employee read(@PathVariable Long employeeNumber)
    {
        return employeeService.read(employeeNumber);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee){
        contactService.update(employee.getContact());
        return employeeService.update(employee);
    }

    @GetMapping("/getAll")
    public Set<Employee> getAll()
    {
        return  employeeService.getAll();
    }


}
