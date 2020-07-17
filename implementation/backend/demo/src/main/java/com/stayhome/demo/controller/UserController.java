package com.stayhome.demo.controller;

import com.stayhome.demo.business.UserBusiness;
import com.stayhome.demo.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {

    public static User Current;

    @Autowired
    private UserBusiness business;

    //create
    @PostMapping("/users")
    public User create (@RequestBody User item){
        Current = item;
        return business.create(item);
    }

    //read//
    @GetMapping( "/users" )
    public List<User> read (){
        return business.findAll();
    }

    //update
    @PutMapping("/users/{id}")
    public User update(
            @PathVariable BigInteger id,
            @RequestBody User item
    ){
        return business.update(item);
    }

    //delete
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable BigInteger id){
        business.delete(id);
    }
}
