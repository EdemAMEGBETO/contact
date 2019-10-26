package com.urbanproduction.contact.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements  IContactService {
    @Autowired
    private ContactRepository contactRepository;

    //Return All the Contact
    @Override
    public List<Contact> getAllTheContacts() {
        return contactRepository.findAll();
    }

    //Return single contact
    @Override
    public Optional<Contact> getContact(int id) {
        return contactRepository.findById(id);
    }

    //Save the contact
    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    //Update the contact
    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    //Remove the contact
    @Override
    public void deleteContact(int id) {
        contactRepository.deleteById(id); }
}
