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
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private final String BASE_URL = "http://localhost:8080/payroll_exercise/contact";

    private static Contact contact;

    @BeforeAll
    public static void setUp(){
       contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597","0712345678");
    }

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Contact> postResponse = testRestTemplate.postForEntity(url, contact, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Contact contactSaved = postResponse.getBody();
        assertEquals(contact.getEmail(), contactSaved.getEmail());
        System.out.println("Saved data: " + contactSaved);
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + contact.getEmail();
//        System.out.println("URL: " + url);

        ResponseEntity<Contact> getResponse = testRestTemplate.getForEntity(url, Contact.class);
        assertEquals(contact.getEmail(), getResponse.getBody().getEmail());
        System.out.println("Read: " + getResponse.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Contact newContact = new Contact.Builder().copy(contact)
                .setMobile("0827762597").build();
        ResponseEntity<Contact> postResponse = testRestTemplate.postForEntity(url, newContact, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Contact contactUpdated = postResponse.getBody();
        assertEquals(newContact.getEmail(), contactUpdated.getEmail());
        System.out.println("Updated data: " + contactUpdated);
    }

//    @Test
//    @Order(4)
//    void delete(){
//        String url = BASE_URL + "/delete/" + contact.getEmail();
//        System.out.println("URL: " + url);
//        testRestTemplate.delete(url);
//        System.out.println("Success: Deleted contact");
//    }

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