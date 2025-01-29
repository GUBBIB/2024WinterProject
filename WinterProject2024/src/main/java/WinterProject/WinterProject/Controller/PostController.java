package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.Board;
import WinterProject.WinterProject.Entity.Post;
import WinterProject.WinterProject.Entity.Users;
import WinterProject.WinterProject.Repository.BoardRepository;
import WinterProject.WinterProject.Repository.PostRepository;
import WinterProject.WinterProject.Repository.UserRepository;
import WinterProject.WinterProject.Service.BoardService;
import WinterProject.WinterProject.Service.PostService;
import WinterProject.WinterProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    @Autowired
    BoardService boardService;

    //    @PreAuthorize("isAuthenticated()")
    @PostMapping("/CreatePostFunction")
    public String createPost(@RequestParam("referer") String referer,
                             @RequestParam("boardId") Long boardId,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             Principal principal) {

        String username = principal.getName();

        Users user = userService.getUserByUserId(username);
        Board board = boardService.getBoardById(boardId);

        postService.createPost(title, content, user, board);

        return "redirect:/BoardPostPage/" + boardId;
    }

    @GetMapping("{boardId}/PostPage/{postId}")
    public String goToPostPage(@PathVariable("boardId") Long boardId,
                               @PathVariable("postId") Long postId,
                               Model model,
                               Principal principal) {

        Post post = postService.getPostByBoardIdAndPostId(boardId, postId);
        String username = principal.getName();

        model.addAttribute("post", post);
        model.addAttribute("username", username);
        return "PostContent";
    }

    @GetMapping("/{boardId}/{postId}/PostModify")
    public String goToModifyPost(@RequestHeader(value = "Referer", required = false) String referer,
                                 @PathVariable("boardId") Long boardId,
                                 @PathVariable("postId") Long postId,
                                 Model model) {

        Post post = postService.getPostByBoardIdAndPostId(boardId, postId);

        model.addAttribute("post", post);
        model.addAttribute("referer", referer);

        return "PostModify";
    }

    @PostMapping("/ModifyPostFunction")
    public String modifyPost(@RequestParam("referer") String referer,
                             @RequestParam("boardId") Long boardId,
                             @RequestParam("postId") Long postId,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content) {

        postService.modifyPost(boardId, postId, title, content);

        return "redirect:/" + boardId + "/PostPage/" + postId;
    }

    @PostMapping("/{boardId}/{postId}/PostDeleteFunction")
    public String deletePost(@PathVariable("boardId") Long boardId, @PathVariable("postId") Long postId){

        postService.deletePost(boardId, postId);

        return "redirect:/BoardPostPage/"+ boardId;
    }
}
