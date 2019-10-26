package com.urbanproduction.contact.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    //Return all the users
    @Override
    public List<User> getAllTheUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    //Return single user
    @Override
    public User getUser(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    //Save the user
    @Override
    public void saveUser(User user) { userRepository.save(user); }

    //Update the user
    @Override
    public void updateUser(User user) { userRepository.save(user); }

    //Remove the user
    @Override
    public void deleteUser(int id) { userRepository.deleteById(id); }

}
