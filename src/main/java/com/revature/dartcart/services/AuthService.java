package com.revature.dartcart.services;

import com.revature.dartcart.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class AuthService {


    @Autowired
    UserService userService;

    public User loadUserByUsername(String username){
        //authorization method checks for the object exist in DB using the username
        User user = userService.getUser(username);
        if(user == null){
            throw new UsernameNotFoundException("No user found of this username:" + username );
        }
        return userService.getUser(username);
    }

}
