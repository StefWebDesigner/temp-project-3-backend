package com.revature.services;

import com.revature.models.User;

import java.util.List;

public interface UserService {

    public User addUser(User user);
    public User getUserById(int id);
    public List<User> getAllUsers();
    public void updateUser(User change);
    public boolean deleteUser(int id);

    User getUserByUsername(String username);

}
