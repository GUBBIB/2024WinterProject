package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.Post;
import WinterProject.WinterProject.Service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import WinterProject.WinterProject.Entity.Board;
import WinterProject.WinterProject.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardPostController {

    private static final Logger logger = LoggerFactory.getLogger(BoardPostController.class);

    @Autowired
    private BoardService boardService;
    @Autowired
    private PostService postService;

    @GetMapping("/BoardPostPage")
    public String goToBoardPostPage(Model model){
        List<Board> boards = boardService.getBoardList();
        model.addAttribute("boards", boards);
        return "BoardPostPage";
    }

    @GetMapping("/BoardManagement")
    public String goToBoardManagement(Model model){
        List<Board> boards = boardService.getBoardList();
        model.addAttribute("boards", boards);
        return "BoardManagement";
    }

    @PostMapping("BoardManagement/BoardCreateFunction")
    public String createBoard(Board board){
        try {
            boardService.saveBoard(board);
        } catch (Exception e){
            return "error";
        }

        return "redirect:/BoardPostPage";
    }

    @PostMapping("/BoardManagement/BoardRemoveFunction")
    public String removeBoard(@RequestParam("boardIds") List<Long> removeList){

        boardService.removeBoardList(removeList);

        return "redirect:/BoardPostPage";
    }

    @GetMapping("/BoardPostPage/{boardId}")
    public String iframeMove(@PathVariable("boardId") Long boardId, Model model){
        Board board = boardService.getBoardById(boardId);
        List<Post> post = postService.getPostList();

        model.addAttribute("board", board);
        model.addAttribute("posts", post);

        return "BoardContent";
    }
}
