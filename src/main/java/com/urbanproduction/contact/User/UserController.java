package com.urbanproduction.contact.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getContacts() {
        return ResponseEntity.ok(userService.getAllTheUsers());
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getContactById(@PathVariable int id) {
        Optional<User> us = userService.getUser(id);
        if(!us.isPresent()){
            System.out.println("id"+id+"n'existe pas!");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(us.get());
    }

    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public ResponseEntity<User> saveContact(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateContact(@PathVariable int id, @Valid @RequestBody User user) {
        if (!userService.getUser(id).isPresent()){
            System.out.println("id"+id+"n'existe pas!");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.updateUser(user));
    }
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        if (!userService.getUser(id).isPresent()){
            System.out.println("id"+id+"n'existe pas!");
            ResponseEntity.badRequest().build();
        }
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
