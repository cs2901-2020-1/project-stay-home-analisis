package com.stayhome.demo.controller;

import com.stayhome.demo.business.UserBusiness;
import com.stayhome.demo.data.StayHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {

    @Autowired
    private UserBusiness business;

    //create
    @PostMapping("/users")
    public StayHome create (@RequestBody StayHome item){
        return business.create(item);
    }

    //read//
    @GetMapping( "/users" )
    public List<StayHome> read (){
        return business.findAll();
    }

    //update
    @PutMapping("/edit_user/{id}")
    public StayHome update(
            @PathVariable BigInteger id,
            @RequestBody StayHome item
    ){
        return business.update(item);
    }

    //delete
    @DeleteMapping("/edit_user/{id}")
    public void delete(@PathVariable BigInteger id){
        business.delete(id);
    }
}
