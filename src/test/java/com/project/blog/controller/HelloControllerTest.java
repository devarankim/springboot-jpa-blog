package com.project.blog.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMVC; //스프링 MVC테스트의 시작점을 의미. 가짜객체임

    @Test
    public void hello() throws Exception {

        String hello = "hello";

        mockMVC.perform(get("/hello")) //GET요청
                .andExpect(status().isOk()) //200상태인지 체크
                .andExpect(content().string(hello)); //BODY에 내용이 HELLO가 맞는지 검증
    }
}
