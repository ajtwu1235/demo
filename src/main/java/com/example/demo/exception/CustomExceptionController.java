package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 글로벌 에러를 잡는 셋팅
 * 상태코드로 응답을 줄 수 도 있다
 */
@RestControllerAdvice
public class CustomExceptionController {

    @ExceptionHandler(MemberNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(NullPointerException e){
        return e.getMessage();
    }
}
