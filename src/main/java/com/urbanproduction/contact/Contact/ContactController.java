package com.urbanproduction.contact.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ContactController {

    @Autowired
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> getContacts() {
         return ResponseEntity.ok(contactService.getAllTheContacts());
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contact> getContactById(@PathVariable int id) {
        Optional<Contact> cont = contactService.getContact(id);
        if(!cont.isPresent()){
            System.out.println("id"+id+"n'existe pas!");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(cont.get());
    }

    @RequestMapping(value = "/contacts/save", method = RequestMethod.POST)
    public ResponseEntity<Contact> saveContact(@Valid @RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.saveContact(contact));
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Contact> updateContact(@PathVariable int id, @Valid @RequestBody Contact contact) {
        if (!contactService.getContact(id).isPresent()){
            System.out.println("id"+id+"n'existe pas!");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(contactService.updateContact(contact));
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Contact> deleteContact(@PathVariable int id) {
        if (!contactService.getContact(id).isPresent()){
            System.out.println("id"+id+"n'existe pas!");
            ResponseEntity.badRequest().build();
        }
        contactService.deleteContact(id);
        return ResponseEntity.ok().build();
    }
}
