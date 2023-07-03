package jupiter.hello.spring4.service;

import jupiter.hello.spring4.model.Board;

import java.util.List;

public interface BoardService {
    List<Board> readBoard(int cpg);
    Board readOneBoard(String bno);     // 매개변수를 int 로 할지 String 으로 할지는
                                        // 값을 산술식에 사용할 것인지를 따지면 된다
    boolean saveBoard(Board bd);
}
