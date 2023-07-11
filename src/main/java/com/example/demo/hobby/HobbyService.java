package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HobbyService {

    private final MemberService memberService;

    public void insertHobby(Hobby.HobbyRequest rq) {
        Member member = memberService.findById(rq.getMemberId()).get();

        Hobby hobby = new Hobby();
        hobby.createHobby(member,rq.getName());
        member.getHobbyList().add(hobby);
        //메모리 hobbyList에도 추가
        Store.hobbies.add(hobby);
    }

    public List<Hobby> findHobbies(){
        return Store.hobbies;
    }

}
