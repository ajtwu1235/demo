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
        Hobby.HobbyDto hobbyDto = new Hobby.HobbyDto(rq.getName());
        member.getHobbyList().add(hobbyDto);

        Hobby hobby = new Hobby();
        Member.MemberDto memberDto = new Member.MemberDto();
        memberDto.setId(member.getId());
        memberDto.setName(member.getName());
        memberDto.setAge(member.getAge());
        hobby.createHobby(memberDto,rq.getName());
        //메모리 hobbyList에도 추가
        Store.hobbies.add(hobby);
    }

    public List<Hobby> findHobbies(){
        return Store.hobbies;
    }

}
