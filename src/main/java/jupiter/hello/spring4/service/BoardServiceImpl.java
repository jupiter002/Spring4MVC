package jupiter.hello.spring4.service;

import jupiter.hello.spring4.dao.BoardDao;
import jupiter.hello.spring4.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("bsrv")
public class BoardServiceImpl implements BoardService{

    @Autowired BoardDao bdao;

    @Override
    public List<Board> readBoard(int cpg) {
        int snum = (cpg - 1) * 15;

        return bdao.selectBoard((snum));
    }
}
