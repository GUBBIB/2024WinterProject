package WinterProject.WinterProject.Service;

import WinterProject.WinterProject.Entity.Board;
import WinterProject.WinterProject.Entity.Comment;
import WinterProject.WinterProject.Entity.Post;
import WinterProject.WinterProject.Entity.Users;
import WinterProject.WinterProject.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void createComment(Post postIdFC, Users userIdFC, String content, Board boardIdFC){
        Comment comment = new Comment();

        comment.setPostIdFC(postIdFC);
        comment.setUserIdFC(userIdFC);
        comment.setContent(content);
        comment.setBoardIdFC(boardIdFC);

        commentRepository.save(comment);
    }

    public List<Comment> getCommentByBoardIdAndPostId(Long boardId, Long postId){

        List<Comment> comment = commentRepository.findByBoardIdFC_BoardIdAndPostIdFC_PostId(boardId, postId);

        return comment;
    }

    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }

}
