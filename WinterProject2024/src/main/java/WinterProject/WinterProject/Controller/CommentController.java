package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.Board;
import WinterProject.WinterProject.Entity.Post;
import WinterProject.WinterProject.Entity.Users;
import WinterProject.WinterProject.Service.BoardService;
import WinterProject.WinterProject.Service.CommentService;
import WinterProject.WinterProject.Service.PostService;
import WinterProject.WinterProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    BoardService boardService;

    @PostMapping("/CreateCommentFunction")
    public String createComment(@RequestParam("referer") String referer,
                                @RequestParam("postId") Long postId,
                                @RequestParam("content") String content,
                                Principal principal){

        String username = principal.getName();

        Users userIdFC = userService.getUserByUserId(username);
        Post postIdFC = postService.getPostByPostId(postId);
        Board boardIdFC = boardService.getBoardById(postIdFC.getBoardIdFP().getBoardId());

        commentService.createComment(postIdFC, userIdFC, content, boardIdFC);

        // boardId/PostPage/postId 위치로 가야함
        return "redirect:" + postIdFC.getBoardIdFP().getBoardId() + "/PostPage/" + postIdFC.getPostId();
    }

    @PostMapping("{commentId}/CommentRemoveFunction")
    public String commentRemoveFunction(@PathVariable("commentId") Long commentId,
                                        @RequestBody Map<String, Long> requestBody){

        Long boardId = requestBody.get("boardId");
        Long postId = requestBody.get("postId");

        commentService.deleteComment(commentId);

        return "redirect:/" + boardId + "/PostPage/" + postId;
    }
}
