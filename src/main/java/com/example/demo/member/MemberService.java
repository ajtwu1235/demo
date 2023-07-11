package com.example.demo.member;

import com.example.demo.exception.MemberNotFound;
import com.example.demo.hobby.Hobby;
import com.example.demo.store.MemberHobby;
import com.example.demo.store.Store;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    public List<Member> findAll(){
        return Store.members;
    }

    public Optional<Member> findById(Integer id){
        Optional<Member> first = Store.members.stream()
                .filter(member -> member.getId() == id)
                .findFirst();

        return first;
    }

    public boolean save(Member.MemberRequest memberRequest){
        Member m =new Member();
        m.createMember(memberRequest);
        Store.members.add(m);
        return true;
    }


    public Member updateById(Integer id, Member.MemberRequest rq) {
        Member byId = findById(id).get();
        byId.setName(rq.getName());
        byId.setAge(rq.getAge());

        return byId;
    }

    public void deleteById(Integer id) {

        Member byId = findById(id).get();
        Store.members.remove(byId);
    }
}
