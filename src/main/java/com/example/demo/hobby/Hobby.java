package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.store.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;


@Data

@AllArgsConstructor
@NoArgsConstructor
public class Hobby {
    private Integer id;

    private Member.MemberDto member;
    private String name;

    // InnerClass로 관리
    @Data
    public static class HobbyRequest{
        private Integer memberId;
        private String name;
    }

    // Member만 따로뺀 Dto 생성

    @Data
    public static class HobbyDto{
        private Integer id;
        private String name;

        public HobbyDto (String name){
            this.id=Store.hobbyIdx;
            this.name=name;
        }

    }

    public Hobby createHobby(Member.MemberDto member,String name){
        this.id =Store.hobbyIdx++;
        this.member=member;
        this.name=name;
        return this;
    }
}
