package jupiter.hello.spring4.dao;

import jupiter.hello.spring4.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("mdao")
public class MemberDaoImpl implements MemberDao{
    //sql.properties에 작성한sql불러오기
    @Value("#{sql['insertMember']}") private String insertSQL;     //@Value

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insertMember(Member m) {
        //매개변수 정의
        Object[] params = new Object[]{
                m.getUserid(), m.getPasswd(),
                m.getUsername(), m.getUseremail()

        };
        //쿼리 실행 : update(sql문, 매개변수)
        return jdbcTemplate.update(insertSQL,params);
    }
}
