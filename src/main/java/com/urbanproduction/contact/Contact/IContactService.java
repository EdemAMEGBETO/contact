package com.urbanproduction.contact.Contact;

import java.util.List;
import java.util.Optional;

public interface IContactService {

    List<Contact> getAllTheContacts();
    Optional<Contact> getContact(int id);
    Contact saveContact(Contact contact);
    Contact updateContact(Contact contact);
    void deleteContact(int id);
}
