package com.revature.services;

import com.revature.models.User;

import java.util.List;

public interface UserService {
    User getUser(String username);
    List<User> getAll();
}
