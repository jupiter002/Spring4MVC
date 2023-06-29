package service;

import jupiter.hello.spring4.dao.MemberDao;
import jupiter.hello.spring4.model.Member;
import jupiter.hello.spring4.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/servlet-context.xml",
        "classpath:spring/root-context.xml"})
@WebAppConfiguration()
public class MemberServiceUnitTest {
    // 테스트할 대상 객체를 주입받음
    @Autowired MemberService msrv;

    @Test
    @Transactional          // insertMember 메서드 모의 실행
    public void saveMember() throws Exception{
        // assertEquals(테스트메서드, 검증값)
        Member m = new Member(null, "abc123a","987xyz","abc123","abc123@987xyz.co.kr",null);
        assertEquals(msrv.saveMemeber(m),true);
    }



}
