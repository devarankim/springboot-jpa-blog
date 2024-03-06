package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //orm관련 엔티티가 클래스 가까이 있는게 좋다.
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;

    @Column(nullable = false, length=100)
    private String title;

    @Lob
    private String content; //섬머노트 라이브러리 <html>태그가 섞여서 디자인 됨.

    @ColumnDefault("0") //int라서 '' 필요가 없음
    private int count;

    //@_ToOne에서는 eager이, tomany에서는 lazy가 기본값.

    //eager은 board를 조회하면 연관관계에 있는 user데이터까지 조회됨.(select에 같이 포함)
    //보통 디폴트로 eager임
    @ManyToOne(fetch=FetchType.EAGER) //연관관계 주입. Many=Board, User=one
    @JoinColumn(name="userId") //자동으로 외래키가 만들어진다.
    private User user; //db는 오브젝트를 저장할 수 없다. fk, 자바는 오브젝트를 저장할 수 있다.

    // lazy 패치전략은 board를 조회하면 board데이터만 들고온다. reply 데이터는 조인만 하고 안들고 옴.
    //드물게 reply가 필요한 곳이면 reply쿼리를 한번 더 날려서 조회하는것이 좋다.
    @OneToMany(mappedBy = "board", fetch=FetchType.LAZY) //mappedby 연관관계의 주인이 아니다(난 fk가 아니에요) db에 컬럼을 만들지 마세요,
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
