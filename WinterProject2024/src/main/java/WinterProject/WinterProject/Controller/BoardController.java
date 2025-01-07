package WinterProject.WinterProject.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import WinterProject.WinterProject.Entity.Board;
import WinterProject.WinterProject.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @GetMapping("/testPage")
    public String goToBoardPostPage(Model model){
        List<Board> boards = boardService.getBoardList();

        if (boards.isEmpty()) {
            logger.warn("No boards found in database.");
        } else {
            logger.debug("Boards retrieved: {}", boards);
        }

        model.addAttribute("boards", boards);
        return "testPage";
    }
}
