package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.Board;
import WinterProject.WinterProject.Entity.Post;
import WinterProject.WinterProject.Entity.Users;
import WinterProject.WinterProject.Repository.BoardRepository;
import WinterProject.WinterProject.Repository.PostRepository;
import WinterProject.WinterProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BoardRepository boardRepository;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/CreatePostFunction")
    public String createPost(@RequestParam("referer") String referer,
                             @RequestParam("boardId") Long boardId,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             Principal principal){

        String username = principal.getName();

        Users user = userRepository.findByUserId(username).get();
        Board board = boardRepository.findByBoardId(boardId).get();

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setBoardIdFP(board);
        post.setUserIdFP(user);

        postRepository.save(post);

        if (referer == null || referer.isEmpty()) {
            return "redirect:/BoardPostPage/BoardContent";
        }

        return "redirect:" + referer;
    }

    @GetMapping("/PostPage/{postId}")
    public String goToPostPage(@PathVariable("postId") Long postId, Model model){

        Post post = postRepository.findByPostId(postId).get();

        model.addAttribute("post", post);

        return "PostContent";
    }
}
