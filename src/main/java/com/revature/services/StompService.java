package com.revature.services;

import com.revature.repositories.StompRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StompService {

    private final StompRepository stompRepository;

    @Autowired
    public StompService(StompRepository stompRepository) {
        this.stompRepository = stompRepository;
    }





}
