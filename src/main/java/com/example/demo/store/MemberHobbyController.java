package com.example.demo.store;


import com.example.demo.hobby.Hobby;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member_hobby")
public class MemberHobbyController {

    @GetMapping
    public List<MemberHobby> AllMemberHobby(){
        return Store.memberHobbyList;
    }

//    @GetMapping
//    public List<MemberHobby> findMHByMember(){
//
//    }
}
