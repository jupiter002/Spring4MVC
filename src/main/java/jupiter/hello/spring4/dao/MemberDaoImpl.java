package jupiter.hello.spring4.dao;

import jupiter.hello.spring4.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("mdao")
public class MemberDaoImpl implements MemberDao {
    //sql.properties에 작성한sql불러오기
    @Value("#{sql['insertMember']}")        //@Value: 필드나 메서드의 파라미터 수준에서
                                            // 표현식 기반으로 값을 주입해주는 어노테이션이고, Spring El으로 값을 주입할 수 있다
    private String insertSQL;
    @Value("#{sql['loginMember']}")
    private String loginSQL;
    @Value("#{sql['selectOneMember']}")
    private String selectOneSQL;

    @Autowired
    JdbcTemplate jdbcTemplate;

    /*@Override
    public int insertMember(Member m) {
        //매개변수 정의
        Object[] params = new Object[]{
                m.getUserid(), m.getPasswd(),
                m.getName(), m.getEmail()

        };
        //쿼리 실행 : update(sql문, 매개변수)
        return jdbcTemplate.update(insertSQL, params);
    }*/


    @Override
    public int insertMember(Member m) {
        Object[] params = new Object[]{
                m.getUserid(), m.getPasswd(),
                m.getName(), m.getEmail()
        };
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
        //단,결과 가 없거나 둘 이상인 경우 예외발생 - 다루기 번거로움
        //JDK 기능 중 Optional 활용하거나 query를 이용해서 단일값또는 값이 없을 때 처리한다
        //query(sql문, 매개변수,매퍼) - 리스트 기반 다중값 반환
        //m = jdbcTemplate.queryForObject(loginSQL, params, mapper);
        List<Member> results =
                jdbcTemplate.query(loginSQL, params, mapper);
        m = results.isEmpty() ? null : results.get(0);
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
                    rs.getString(1), rs.getString(2),
                    null,rs.getString(4),
                    rs.getString(5),rs.getString(6)
            );
            return m;
        }
    }
}
