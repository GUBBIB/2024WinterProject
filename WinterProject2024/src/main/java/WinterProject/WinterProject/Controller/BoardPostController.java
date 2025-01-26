package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.Post;
import WinterProject.WinterProject.Service.PostService;
import org.springframework.stereotype.Controller;
import WinterProject.WinterProject.Entity.Board;
import WinterProject.WinterProject.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardPostController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private PostService postService;

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


    @GetMapping("/BoardPostPage")
    public String goToBoardPostPage(Model model){
        List<Board> boards = boardService.getBoardList();
        model.addAttribute("boards", boards);
        return "BoardPostPage";
    }
    @GetMapping("/BoardPostPage/{boardId}")
    public String iframeMove(@PathVariable("boardId") Long boardId, Model model){
        Board board = boardService.getBoardById(boardId);
        List<Post> getAllPost = postService.getPostList();
        List<Post> posts = new ArrayList<>();

        for(Post post : getAllPost){
            if(post.getBoardIdFP().getBoardId() == boardId){
                posts.add(post);
            }
        }

        model.addAttribute("isBoardSelected", 1);

        if(posts.isEmpty()){
            model.addAttribute("message", "게시글을 작성해 보세요!");
        } else {
            model.addAttribute("posts", posts);
        }

        model.addAttribute("board", board);
        return "BoardContent";
    }

    @GetMapping("/BoardPostPage/BoardContent")
    public String basicIframePage(Model model){
        model.addAttribute("isBoardSelected", 0);

        return "BoardContent";
    }

    @GetMapping("/BoardPostPage/{boardId}/CreatePost")
    public String goToCreatePost(@PathVariable("boardId") Long boardId, @RequestHeader(value = "Referer", required = false) String referer, Model model){
        model.addAttribute("boardId", boardId);
        model.addAttribute("referer", referer);
        return "CreatePost";
    }
}
