package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.demography.Contact;
import za.ac.cput.repository.ContactRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContactService implements IContactService{

    public ContactRepository contactRepository;

    @Autowired
    ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact read(String email) {
        return contactRepository.findById(email).orElse(null);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void delete(String email) {
        contactRepository.deleteById(email);
    }

    @Override
    public Set<Contact> getAll() {
        return contactRepository.findAll().stream().collect(Collectors.toSet());
    }
}
