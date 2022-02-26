package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepo repo;

    @Override
    public User getUser(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) repo.findAll();
    }
}
