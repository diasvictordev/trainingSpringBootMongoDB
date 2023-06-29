package com.mongodbtraining.mongotraining.resources;

import com.mongodbtraining.mongotraining.domain.User;
import com.mongodbtraining.mongotraining.dto.UserDTO;
import com.mongodbtraining.mongotraining.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/user")
public class UserResource {

    @Autowired
    private UserService service;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll (){
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }
}
