package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.demography.Contact;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

    // find all employees with last name = (Langa)
    List<Employee> findAllByLastnameIs(String lastName);



    //find all employees with name that starts wih = (S)
    List<Employee> findAllByFirstNameStartingWith(String myString);



    // get employee with email = ("221069054@mcput.ac.za")
    Employee findEmployeeByContactIs(Contact contact);
    Employee findByContactIs(Contact contact);



    // find all employees by name and order in DESC o
    List<Employee> findByFirstNameOrderByFirstNameDesc(String firstName);

}
