package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.demography.Contact;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactFactoryTest {

    private Contact contact;

    @Test
    @Order(1)
    void buildContact()
    {
        contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597", "0712345678");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(2)
    void buildContactWithFail1()
    {
        contact = ContactFactory.buildContact("","0727762597", "0712345678");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(3)
    void  buildContactWithFail2()
    {
        contact = ContactFactory.buildContact("221069054mycput.ac.za", "0727762597", "0712345678");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(4)
    void buildContactWithFail3()
    {
        contact = ContactFactory.buildContact("@mycput.ac.za", "0727762597", "0712345678");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(5)
    void buildContactWithFail4()
    {
        contact = ContactFactory.buildContact("221069054@.ac.za", "0727762597", "0712345678");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(6)
    void buildContactWithFail5()
    {
        contact = ContactFactory.buildContact("221069054@mycput", "0727762597", "0712345678");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(7)
    void buildContactWithFail6()
    {
        contact = ContactFactory.buildContact("221069054@mycput.ac.za", "07277625", "0712345678");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(8)
    void buildContactWithFail7()
    {
        contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597", "07123456");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(9)
    void buildContactWithFail8()
    {
        contact = ContactFactory.buildContact("221069054@mycput.ac.za", "07277625971", "0712345678");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(10)
    void buildContactWithFail9()
    {
        contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597", "07123456783");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(11)
    void buildContactWithFail10()
    {
        contact = ContactFactory.buildContact("221069054@mycput.ac.za", "leonardlan", "0712345678");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(12)
    void buildContactWithFail11()
    {
        contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597", "leonardlan");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(13)
    void buildContactWithFail12()
    {
        contact = ContactFactory.buildContact("221069054@mycput.ac.za", "072776T2597", "0712345678");
        assertNotNull(contact);
        System.out.println(contact);
    }

    @Test
    @Order(14)
    void buildContactWithFail13()
    {
        contact = ContactFactory.buildContact("221069054@mycput.ac.za", "0727762597", "07123P45678");
        assertNotNull(contact);
        System.out.println(contact);
    }
}