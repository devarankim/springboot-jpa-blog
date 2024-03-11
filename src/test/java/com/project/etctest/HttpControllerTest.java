package com.project.etctest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답(Html)(jsp..)이면 @Controller
//사용자가 요청 -> 응답(Data)

//레거시 스프링
//root-context.xml : 한번만 new되는 애들 싱글톤인 것들만
//servlet-context.xml : 지속적으로 new해야하는
@RestController
public class HttpControllerTest {

    @GetMappint("/http/lombok")
    public String lombokTest(){
        Member m = Member.builder().username("kimaran").password("1234").email("ssar@nate.com").build();
        //builder패턴은 순서지킬필요가 없다.
        return "lombok test 완료"
    }
    //인터넷 요청은(브라우저)는 get만 가능하다.
    @GetMapping
    //public String getTest(Member m){ //이렇게도 가능 (quertstring형식으로 보내도 messageConverter가 객체에 매핑해서 보여준다
    public String getTest(@RequestParam int id){
        return null;
    }

    @PostMapper("/http/post")
    public String postTest(@RequestBody Member m){ //application/json형식으로 보내게 되면 알아서 객체에 파싱해서 넣어줌. MessageConverter(부트)다
        return "post요청: " + m.getId() + "," + m.getUsername();
    }
}


//그래들
//runtimeonly : 런타임에만 필요함. 빌드시점에는 추가하지 않고 런타임때만 추가.

//complieonly : 컴파일 시점에만 필요함. 빌드된 결과물에는 포함하지 않음. 컴파일 시점에만 라이브러리 참조.
 //              예를들어 테스트코드를 작성할 때 Junit라이브러리를 설정하여 테스트코드 컴파일 시점에만 라이브러리를 참조하도록 처리

//implementation : 라이브러리가 컴파일 및 런타임 모두 필요하다는 것을 나타냄., 클래스 및 메서드를 프로젝트에서 직접 참조 가능

