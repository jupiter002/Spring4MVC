package jupiter.hello.spring4.dao;

import jupiter.hello.spring4.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("mdao")
public class MemberDaoImpl implements MemberDao {
    //sql.properties에 작성한sql불러오기
    @Value("#{sql['insertMember']}")
    private String insertSQL;     //@Value
    @Value("#{sql['loginMember']}")
    private String loginSQL;     //@Value
    @Value("#{sql['selectOneMember']}")
    private String selectOneSQL;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insertMember(Member m) {
        //매개변수 정의
        Object[] params = new Object[]{
                m.getUserid(), m.getPasswd(),
                m.getName(), m.getEmail()

        };
        //쿼리 실행 : update(sql문, 매개변수)
        return jdbcTemplate.update(insertSQL, params);
    }

    public Member loginMember(Member m) {
        //매개변수 정의
        Object[] params = new Object[]{         // 배열로 넘어오는 값을 Object[] 변수로 받음
                m.getUserid(), m.getPasswd()

        };
        // 로그인 매퍼 선언 = 콜백함수
        RowMapper<Member> mapper = new LoginMapper();       // 무슨일이 일어나면 mapper가 처리할것

        //쿼리 실행 : queryForObject(sql문, 매개변수,매퍼) - 단일값 반환
        m = jdbcTemplate.queryForObject(loginSQL, params, mapper);
        return m;
    }

    private class LoginMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int num) throws SQLException {
            Member m = new Member();
            m.setUserid(rs.getString(1));
            m.setName(rs.getString(2));

            return m;
        }
    }

    public Member selectOneMember(String userid){

        Object[] params = new Object[]{
                userid
        };
        RowMapper<Member> mapper = new MemberMapper();

        return jdbcTemplate.queryForObject(
                selectOneSQL, params, mapper);

    }


    private class MemberMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int num) throws SQLException {
            Member m = new Member(
            rs.getString(1), rs.getString(3),
                    null,rs.getString(4),
                    rs.getString(5),rs.getString(6)
            );
            return m;
        }
    }
}
