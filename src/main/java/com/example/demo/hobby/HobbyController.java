package com.example.demo.hobby;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hobby")
public class HobbyController {

    private final HobbyService hobbyService;

    @GetMapping()
    public List<Hobby> AllHobby(){
        return hobbyService.findHobbies();
    }

    @PostMapping()
    public void insertHobby(@RequestBody Hobby.HobbyRequest rq){
        hobbyService.insertHobby(rq);
    }

}
