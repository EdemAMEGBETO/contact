package com.urbanproduction.contact.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    //Return all the users
    @Override
    public List<User> getAllTheUsers() {
        return userRepository.findAll();
    }

    //Return single user
    @Override
    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }

    //Save the user
    @Override
    public User saveUser(User user) {
        return userRepository.save(user); }

    //Update the user
    @Override
    public User updateUser(User user) {
        return userRepository.save(user); }

    //Remove the user
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id); }

}
