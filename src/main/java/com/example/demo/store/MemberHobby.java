package com.example.demo.store;

import com.example.demo.hobby.Hobby;
import com.example.demo.member.Member;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberHobby {
    @JsonIgnoreProperties("memberHobbyList")
    private Member member;
    @JsonIgnoreProperties("memberHobbyList")
    private Hobby  hobby;
}
