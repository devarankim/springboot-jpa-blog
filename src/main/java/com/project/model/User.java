package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
// ORM -> Java(다른언어) Object-> 테이블로 매핑해주는 기술.
//jpa는 java persistencte api의 약자로 자바 애플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스와 어노테이션의 표준 집합을 정의함. 인터페이스임.
//관계형데이터베이스를 어떻게 사용해야 하는지 정의하는 한 방법일 뿐 구현은 없고 다양한 ORM프로엠워크에서 구현할 수 있는 공통 api를 제공함.
@Entity //User클래스가 Mysql에 테이블이 생성이 된다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; //시퀀스, auto_increment
    @Column(nullable=false, length=30)
    private String username;
    @Column(nullable=false, length=100)
    private String password;
    @Column(nullable=false, length=50)
    private String email;

    @ColumnDefault("'user'")
    private String role; //Enum을 쓰는게 좋다. 도메인을 사용 가능 ex)admin, user, manager...
    @CreationTimestamp //시간이 자동 입력
    private Timestamp createDate;

}
