package jupiter.hello.spring4.dao;

import jupiter.hello.spring4.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("bdao")
public class BoardDaoImpl implements BoardDao{
    @Value("#{sql['selectBoard']}") private String selectSQL;
    @Value("#{sql['selectOneBoard']}") private String selectOneSQL;

    @Autowired JdbcTemplate jdbcTemplate;
    @Override
    public List<Board> selectBoard(int snum) {
        Object[] params = new Object[]{snum};

        RowMapper<Board> mapper = new SelectMapper();

        return jdbcTemplate.query(selectSQL,params,mapper);
    }



    private class SelectMapper implements RowMapper<Board> {
        @Override
        public Board mapRow(ResultSet rs, int num) throws SQLException {
            Board bd = new Board(rs.getString(1),rs.getString(2),
                    rs.getString(3),rs.getString(4),
                    rs.getString(5),"0");
            return bd;
        }
    }   //selectmapper

    @Override
    public Board selectOneBoard(String bno) {
        Object[] params = new Object[]{bno};
        RowMapper<Board> SelectOneMapper = new SelectOneMapper();
        return jdbcTemplate.queryForObject(selectOneSQL,params,SelectOneMapper);
    }
    private class SelectOneMapper implements RowMapper<Board> {
        @Override
        public Board mapRow(ResultSet rs, int num) throws SQLException {
            Board bd = new Board(rs.getString(1),rs.getString(2),
                    rs.getString(3),rs.getString(4),
                    rs.getString(5),rs.getString(6));
            return bd;
        }
    }   //selectOneMappper
}       // class
