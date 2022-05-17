package com.revature.controllers;


import com.revature.services.StompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/greeting")
public class StompController {


    private final StompService stompService;

    @Autowired
    public StompController(StompService stompService) {
        this.stompService = stompService;
    }




}
