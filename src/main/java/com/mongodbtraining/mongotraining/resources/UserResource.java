package com.mongodbtraining.mongotraining.resources;

import com.mongodbtraining.mongotraining.domain.User;
import com.mongodbtraining.mongotraining.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserResource {

    @Autowired
    private UserService service;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll (){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
