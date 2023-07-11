package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.store.MemberHobby;
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

        Hobby hobbyByName = findHobbyByName(rq.getName());
        //새로운 취미가 입력으로 받았을때
        if(hobbyByName==null){
            //새로운 취미를 생성하자!
            Hobby hobby = new Hobby();
            Hobby newHobby = hobby.createHobby(member, rq.getName());
            Store.hobbies.add(newHobby);

            //새로운 Member_hobby
            MemberHobby memberHobby = new MemberHobby();
            memberHobby.setMember(member);
            memberHobby.setHobby(newHobby);
            Store.memberHobbyList.add(memberHobby);


            //메모리 Member, Hobby 에도 추가
            member.getMemberHobbyList().add(memberHobby);
            newHobby.getMemberHobbyList().add(memberHobby);
        }
        //이미 기존 취미 데이터가 있을경우
        else{
            MemberHobby memberHobby = new MemberHobby();
            memberHobby.setMember(member);
            memberHobby.setHobby(hobbyByName);
            Store.memberHobbyList.add(memberHobby);


            //메모리 Member, Hobby 에도 추가
            member.getMemberHobbyList().add(memberHobby);
            hobbyByName.getMemberHobbyList().add(memberHobby);
        }


    }

    public List<Hobby> findHobbies(){
        return Store.hobbies;
    }


    /**
     * 취미 이름으로 취미 Seq를 탐색
     * @param name
     * @return
     */
    public Hobby findHobbyByName(String name){

        for(int i=0;i<Store.hobbies.size();i++){

            Hobby hobby = Store.hobbies.get(i);

            if(hobby.getName().equals(name)){
                return hobby;
            }
        }

        return null;
    }

}
