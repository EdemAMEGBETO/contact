package com.urbanproduction.contact.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements  IContactService {
    @Autowired
    private ContactRepository contactRepository;

    //Return All the Contact
    @Override
    public List<Contact> getAllTheContacts() {
        List<Contact> contactList = new ArrayList<>();
        contactRepository.findAll().forEach(contactList::add);
        return contactList;
    }

    //Return single contact
    @Override
    public Contact getContact(int id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            return optionalContact.get();
        }
        return null;
    }

    //Save the contact
    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    //Update the contact
    @Override
    public void updateContact(Contact contact) {
        contactRepository.save(contact);
    }

    //Remove the contact
    @Override
    public void deleteContact(int id) { contactRepository.deleteById(id); }
}
