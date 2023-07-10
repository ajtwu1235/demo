package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    private List<User> list =  new ArrayList<User>();

    public DemoController(){
        list.add(new User("태홍",25));
    }

    @GetMapping
    public String test(){
        return "test";
    }

    @GetMapping("{name}")
    public List<User> findName (@PathVariable String name){

        return list.stream()
                .filter(user -> user.getName().equals(name))
                .toList();
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody User user){

        long count = list.stream().filter(u -> u.getName().equals(user.getName())).count();

        System.out.println(count);
        if(count==0){
            list.add(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
