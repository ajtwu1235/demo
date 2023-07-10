package com.example.demo.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public List<Member> findAll(){
        return memberService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Member> findById(@PathVariable Integer id){

        if(memberService.findById(id)==null){
            System.out.println("데이터가 없음");

        }

        return memberService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean save(@RequestBody Member.MemberRequest memberRequest){
        return memberService.save(memberRequest);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateById(@PathVariable Integer id, @RequestBody Member.MemberRequest rq){
        memberService.updateById(id, rq);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable Integer id){
        memberService.deleteById(id);
    }
}
