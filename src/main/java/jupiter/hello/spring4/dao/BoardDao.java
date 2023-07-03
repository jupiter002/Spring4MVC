package jupiter.hello.spring4.dao;

import jupiter.hello.spring4.model.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bdao")
public interface BoardDao {

    List<Board> selectBoard(int snum);
    Board selectOneBoard(String bno);
    int insertBoard(Board bd);
}
