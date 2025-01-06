package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.Board;
import WinterProject.WinterProject.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/BoardPostPage")
    public String goToBoardPostPage(Model model){

        List<Board> boards = boardService.getBoardList();
        model.addAttribute("boards", boards);
        return "BoardPostPage";
    }
}
