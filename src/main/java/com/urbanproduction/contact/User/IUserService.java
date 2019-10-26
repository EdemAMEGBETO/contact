package com.urbanproduction.contact.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> getAllTheUsers();
    Optional<User> getUser(int id);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(int id);
}
