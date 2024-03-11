package com.project.etctest;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor//final 변수만 생성자 만들어줌
public class Member {
    //변수의 직접적으로 접근하는건 객체지향에 맞지 않다.
    //변수의 상태는 무조건 메소드를 통하여 변경이 되도록 처리해야 한다.
    private int id;
    private String username;
    private String password;
    private String email;

    @Builder
    public Member(int id, String username, String password, String email){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
