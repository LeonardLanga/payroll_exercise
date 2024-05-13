package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.demography.Contact;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactServiceTest {

    @Autowired
    private ContactService service;

    private Contact contact = ContactFactory.buildContact("221069054@mycput.ac.za","0727762597", "0712345678");

    @Test
    @Order(1)
    void create() {
        Contact created = service.create(contact);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        Contact read = service.read(contact.getEmail());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Contact newContact = new Contact.Builder().copy(contact)
                .setMobile("0827762597").build();
        Contact updated = service.update(newContact);
        assertNotNull(updated);
        System.out.println(updated);
    }

//    @Test
//    @Order(4)
//    void delete(){
//        Contact toDelete = service.read(contact.getEmail());
//        boolean deleted = service.delete(toDelete.getEmail());
//        assertTrue(deleted);
//    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(service.getAll());
    }



}