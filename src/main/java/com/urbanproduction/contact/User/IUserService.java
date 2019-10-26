package com.urbanproduction.contact.User;

import java.util.List;

public interface IUserService {

    List<User> getAllTheUsers();
    User getUser(int id);
    void  saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
