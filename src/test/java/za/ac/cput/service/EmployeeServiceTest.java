package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.demography.Contact;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceTest {

    @Autowired
    EmployeeService service;

    private Contact contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597", "0712345678");
    private Employee employee = EmployeeFactory.buildEmployee(1L,"Leonard", "Langa", contact);

    @Test
    @Order(1)
    void create() {
        Employee created = service.create(employee);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        Employee read = service.read(employee.getEmployeeNumber());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Contact newContact = new Contact.Builder().copy(employee.getContact())
                .setMobile("0827762597").build();
        assertNotNull(newContact);

        Employee editedEmployee = new Employee.Builder().copy(employee)
                .setContact(newContact).build();
        assertNotNull(editedEmployee);

        Employee updated = service.update(editedEmployee);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(service.getAll());
    }
}