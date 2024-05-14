package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.demography.Contact;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

    //find all contacts with email starting with = (S)
    List<Contact> findAllByEmailStartingWith(String myString);



    //get contact with mobile = "0727762597"
    Contact findByMobileIs(String mobile);
    Contact findContactByWorkTelephoneIs(String mobile);



    //find all contacts with an email that contains = (@gmail)
    List<Contact> findAllByEmailContaining(String myString);



    //find all contacts with an email that ends with = (za)
    List<Contact> findAllByEmailEndingWith(String myString);



}
