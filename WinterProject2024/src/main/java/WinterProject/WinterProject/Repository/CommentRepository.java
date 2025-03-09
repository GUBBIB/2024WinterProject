package WinterProject.WinterProject.Repository;

import WinterProject.WinterProject.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardIdFC_BoardIdAndPostIdFC_PostId(Long boardId, Long postId);

}
