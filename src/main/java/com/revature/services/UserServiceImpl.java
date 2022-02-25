package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepo ur;

    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    public User addUser(User user)
    {
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        return ur.save(user);
    }

    @Override
    public User getUserById(int id) {
        return ur.findById(id).orElse(new User());
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) ur.findAll();
    }

    @Override
    public void updateUser(User change) {
        ur.save(change);
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            ur.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByUsername(String username) {
        return ur.findByUsername(username);
    }

}
