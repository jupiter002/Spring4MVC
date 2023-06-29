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
public class MemberDaoImpl implements MemberDao{
    //sql.properties에 작성한sql불러오기
    @Value("#{sql['insertMember']}") private String insertSQL;     //@Value
    @Value("#{sql['loginMember']}") private String loginSQL;     //@Value

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
        return jdbcTemplate.update(insertSQL,params);
    }

    public Member loginMember(Member m) {
        //매개변수 정의
        Object[] params = new Object[]{
                m.getUserid(), m.getPasswd()

        };
        // 로그인 매퍼 선언 = 콜백함수
        RowMapper<Member> mapper = new LoginMapper();       // 무슨일이 일어나면 mapper가 처리할것

        //쿼리 실행 : queryForObject(sql문, 매개변수,매퍼) - 단일값 반환
        return jdbcTemplate.queryForObject(loginSQL,params,mapper);
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
}
