package WinterProject.WinterProject.Repository;

import WinterProject.WinterProject.Entity.Board;
import WinterProject.WinterProject.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();
    Optional<Post> findByPostId(Long postId);
    Optional<Post> findByBoardIdFP_BoardIdAndPostId(Long boardId, Long postId);

}
