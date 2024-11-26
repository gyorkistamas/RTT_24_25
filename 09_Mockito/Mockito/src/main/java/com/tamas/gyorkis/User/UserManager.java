package com.tamas.gyorkis.User;

import java.util.List;

public class UserManager {
    private UserService userService;

    public UserManager(UserService userService) {
        this.userService = userService;
    }

    public String getUsernameById(int id) {
        User user = userService.getUser(id);
        return user != null ? user.getName() : null;
    }

    public void updateUserName(int userId, String newName) {
        User user = userService.getUser(userId);
        if (user != null) {
            user.setName(newName);
            userService.updateUser(user);
        }
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
