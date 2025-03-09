package WinterProject.WinterProject.Service;

import WinterProject.WinterProject.Entity.Board;
import WinterProject.WinterProject.Entity.Post;
import WinterProject.WinterProject.Entity.Users;
import WinterProject.WinterProject.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void createPost(String title, String content, Users user, Board board){
        Post post = new Post();

        post.setTitle(title);
        post.setContent(content);
        post.setBoardIdFP(board);
        post.setUserIdFP(user);

        postRepository.save(post);
    }
    public List<Post> getPostList(){
        List<Post> posts = postRepository.findAll();

        return posts;

    }
    public Post getPostByBoardIdAndPostId(Long boardId, Long postId){

        Post post = postRepository.findByBoardIdFP_BoardIdAndPostId(boardId, postId).get();

        return post;
    }

    public Post getPostByPostId(Long postId){

        Post post = postRepository.findByPostId(postId).get();

        return post;
    }

    public void modifyPost(Long boardId, Long postId, String title, String content) {
        Post post = postRepository.findByBoardIdFP_BoardIdAndPostId(boardId, postId).get();

        post.setTitle(title);
        post.setContent(content);

        postRepository.save(post);
    }
    public void deletePost(Long boardId, Long postId){
        Post post = postRepository.findByBoardIdFP_BoardIdAndPostId(boardId, postId).get();

        postRepository.deleteById(post.getPostId());
    }
}
