package com.urbanproduction.contact.Contact;

import java.util.List;

public interface IContactService {

    List<Contact> getAllTheContacts();
    Contact getContact(int id);
    void  saveContact(Contact contact);
    void updateContact(Contact contact);
    void deleteContact(int id);
}
