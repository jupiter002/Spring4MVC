package jupiter.hello.spring4.controller;

import jupiter.hello.spring4.model.Board;
import jupiter.hello.spring4.service.BoardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired BoardService bsrv;
    private Logger logger = LogManager.getLogger(BoardController.class);
    @GetMapping("/list")
    public String list(Model m, int cpg){

        logger.info("board/list호출");

        m.addAttribute("boards",bsrv.readBoard(cpg));
        //m.addAttribute("psnum",);       // 페이지네이션 시작 번호
        //m.addAttribute("allpg",);       // 총페이지

        return "board/list.tiles";
    }
    @GetMapping("/write")
    public String write(Model m){

        logger.info("board/write호출");

        return "board/write.tiles";
    }
    @GetMapping("/view")
    public String view(Model m,String bno){

        logger.info("board/view호출");
        Board board = bsrv.readOneBoard(bno);
        m.addAttribute("Oneview",board);

        return "board/view.tiles";
    }

}