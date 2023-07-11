package com.example.demo.member;

import com.example.demo.hobby.Hobby;
import com.example.demo.store.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

@Data //Getter,Setter,ToString,Equals,HashCode
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Integer id;
    private String name;

    private Integer age;

    private List<Hobby> hobbyList =new ArrayList<>();

    //InnerClass로 응집도를 높여봤다.
    @Data
    public static class MemberRequest{
        private String name;
        private Integer age;
    }


    //hobbyList만 뺀 MemberDto생성
    @Data
    public static class MemberDto{
        Integer id;
        String name;
        Integer age;
    }

    public Member createMember(MemberRequest memberRequest){
        this.id= Store.memberIdx++;
        this.name=memberRequest.getName();
        this.age=memberRequest.getAge();
        return this;
    }
}
