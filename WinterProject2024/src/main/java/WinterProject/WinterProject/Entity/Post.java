package WinterProject.WinterProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue
    private Long post_id;
    private Long board_id;
    private Long user_id;
    private String title;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
