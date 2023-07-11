package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.store.MemberHobby;
import com.example.demo.store.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hobby {
    private Integer id;
    private String name;

    @JsonIgnoreProperties("hobby")
    private List<MemberHobby> memberHobbyList =new ArrayList<>();


    // InnerClass로 관리
    @Data
    public static class HobbyRequest{
        private Integer memberId;
        private String name;
    }

    // Member만 따로뺀 Dto 생성

//    @Data
//    public static class HobbyDto{
//        private Integer id;
//        private String name;
//        public HobbyDto (String name){
//            this.id=Store.hobbyIdx;
//            this.name=name;
//        }
//
//    }

    public Hobby createHobby(Member member, String name){
        this.id =Store.hobbyIdx++;
        this.name=name;
        return this;
    }
}
