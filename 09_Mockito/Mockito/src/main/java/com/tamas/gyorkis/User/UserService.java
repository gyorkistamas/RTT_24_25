package com.tamas.gyorkis.User;

import java.util.List;

public interface UserService {
    User getUser(int id);
    void updateUser(User user);
    List<User> getAllUsers();
}
