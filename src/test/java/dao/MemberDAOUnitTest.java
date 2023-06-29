package dao;

import jupiter.hello.spring4.dao.MemberDao;
import jupiter.hello.spring4.model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)     // junit spring 연동
@ContextConfiguration({"classpath:spring/servlet-context.xml",
        "classpath:spring/root-context.xml"})
@WebAppConfiguration()
public class MemberDAOUnitTest {
    @Autowired
    MemberDao mdao;

    @Test           // insertMember 메서드 모의 실행
    @Transactional          // 데이터 입력 후 자동 삭제
    public void insertMember() throws Exception{
        // assertEquals(테스트메서드, 검증값)
        Member m = new Member(null, "abc123a","987xyz","abc123","abc123@987xyz.co.kr",null);
        assertEquals(mdao.insertMember(m),1);
    }



}
