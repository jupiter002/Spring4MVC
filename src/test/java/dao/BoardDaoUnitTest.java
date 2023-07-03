package dao;

import jupiter.hello.spring4.dao.BoardDao;
import jupiter.hello.spring4.model.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)     // junit spring 연동
@ContextConfiguration({"classpath:spring/servlet-context.xml",
        "classpath:spring/root-context.xml"})
@WebAppConfiguration()
public class BoardDaoUnitTest {
    @Autowired
    BoardDao bdao;

    @Test           // insertMember 메서드 모의 실행
    public void selectBoard() throws Exception{
        int cpage = 20;
        int snum = (cpage - 1) * 15;
        List<Board> results = bdao.selectBoard(snum);
        assertEquals(results.size(),15);
        System.out.println(results);
    }
    @Test
    public void selectOneBoard() throws Exception{
        String bno = "450";
        Board result = bdao.selectOneBoard(bno);
        assertNotNull(result);
        System.out.println(result);
    }
    @Test
    @Transactional
    public void insertBoard() throws Exception{
        Board bd = new Board(null,"abc123","테스트","테스트컨텐츠",null,null);
        assertEquals(bdao.insertBoard(bd),1);
    }
}
