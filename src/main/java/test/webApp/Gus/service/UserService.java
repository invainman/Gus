package test.webApp.Gus.service;


import test.webApp.Gus.entity.User;

import java.util.List;


public interface UserService{

    User create(User user);

    List<User> getAllUsers();

    void delete(String email);

    User getUser(String email);

    User update(User user);

    User getCurrentUser();

}