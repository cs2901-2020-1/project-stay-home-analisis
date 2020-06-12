package com.stayhome.demo.controller;

import com.stayhome.demo.business.StayHomeBusiness;
import com.stayhome.demo.data.StayHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/")
public class StayHomeController {

    @GetMapping("/test")
    public String test(@RequestParam(value = "name", defaultValue = "user") String name) {
        return String.format("Hello %s!, your spring-boot app is running correctly", name);
    }

    @Autowired
    private StayHomeBusiness business;

    //create
    @PostMapping("/")
    public StayHome create (@RequestBody StayHome item){
        return business.create(item);
    }

    //read
    @GetMapping("/")
    public List<StayHome> read (){
        return business.findAll();
    }

    //update
    @PutMapping("/{id}")
    public StayHome update(
            @PathVariable BigInteger id,
            @RequestBody StayHome item
    ){
        return business.update(item);
    }

    //delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable BigInteger id){
        business.delete(id);
    }
}
