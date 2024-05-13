package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.demography.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private final String BASE_URL = "http://localhost:8080/payroll_exercise/employee";

    private static Contact contact;

    private static Employee employee;


    @BeforeAll
    public static void setUp() {
        contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597","0712345678");
        employee = EmployeeFactory.buildEmployee(1,"Leonard", "Langa", contact);
    }

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Employee> postResponse = testRestTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Employee employeeSaved = postResponse.getBody();
        assertEquals(employee.getEmployeeNumber(), employeeSaved.getEmployeeNumber());
        System.out.println("Saved data: " + employeeSaved);

    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + employee.getEmployeeNumber();

        ResponseEntity<Employee> getResponse = testRestTemplate.getForEntity(url, Employee.class);
        assertEquals(employee.getEmployeeNumber(), getResponse.getBody().getEmployeeNumber());
        System.out.println("Read: " + getResponse.getBody());

    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Contact newContact = new Contact.Builder().copy(contact)
                .setMobile("0827762597").build();
        Employee editedEmployee = new Employee.Builder().copy(employee)
                .setContact(newContact).build();
        ResponseEntity<Employee> postResponse = testRestTemplate.postForEntity(url, editedEmployee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Employee employeeUpdated = postResponse.getBody();
        assertEquals(editedEmployee.getEmployeeNumber(), employeeUpdated.getEmployeeNumber());
        System.out.println("Updated data: " + employeeUpdated);

    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> getResponse = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(getResponse);
        System.out.println(getResponse.getBody());
    }
}