package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.demography.Contact;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeFactoryTest {

    @Test
    @Order(1)
    void buildEmployee1() {
        Contact contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597", "0712345678");
        Employee employee = EmployeeFactory.buildEmployee(1234L,"Leonard","Langa", contact);
        assertNotNull(employee);
        System.out.println(employee);
    }

    @Test
    @Order(2)
    void buildEmployee1WithFailA(){
        Contact contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597", "0712345678");
        Employee employee = EmployeeFactory.buildEmployee(0,"Leonard","Langa", contact);
        assertNotNull(employee);
        System.out.println(employee);
    }

    @Test
    @Order(3)
    void buildEmployee1WithFailB(){
        Contact contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597", "0712345678");
        Employee employee = EmployeeFactory.buildEmployee(-123L,"Leonard","Langa", contact);
        assertNotNull(employee);
        System.out.println(employee);
    }

    @Test
    @Order(4)
    void buildEmployee1WithFailC(){
        Contact contact = null;
        Employee employee = EmployeeFactory.buildEmployee(-123L,"Leonard","Langa", contact);
        assertNotNull(employee);
        System.out.println(employee);
    }

    @Test
    @Order(5)
    void buildEmployee1WithFailD(){
        Contact contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597", "0712345678");
        Employee employee = EmployeeFactory.buildEmployee(123L,"","Langa", contact);
        assertNotNull(employee);
        System.out.println(employee);
    }

    @Test
    @Order(6)
    void buildEmployee1WithFailE(){
        Contact contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597", "0712345678");
        Employee employee = EmployeeFactory.buildEmployee(123L,"Leonard","", contact);
        assertNotNull(employee);
        System.out.println(employee);
    }

    @Test
    @Order(7)
    void buildEmployee2() {
        Employee employee = EmployeeFactory.buildEmployee(5678L,"Gabriel", "Langa",
                "gabriellanga56@gmail.com", "0827762597","0812345678");
        assertNotNull(employee);
        System.out.println(employee);
    }


    @Test
    @Order(8)
    void buildEmployee3() {
        Contact contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597", "0712345678");
        Employee employee = EmployeeFactory.buildEmployee("Leonard","Langa", contact);
        assertNotNull(employee);
        System.out.println(employee);
    }

    @Test
    @Order(9)
    void buildEmployee4() {
        Employee employee = EmployeeFactory.buildEmployee("Gabriel", "Langa",
                "gabriellanga56@gmail.com", "0827762597","0812345678");
        assertNotNull(employee);
        System.out.println(employee);
    }
}