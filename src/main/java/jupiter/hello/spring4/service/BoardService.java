package jupiter.hello.spring4.service;

import jupiter.hello.spring4.model.Board;

import java.util.List;

public interface BoardService {
    List<Board> readBoard(int cpg);
}
