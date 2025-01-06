package WinterProject.WinterProject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    private Long postId;
    @ManyToOne
    @JoinColumn(name = "boardId", nullable = false)
    private Board boardIdF;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User userIdF;
    @Column(length = 255, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(columnDefinition = "BIGINT DEFAULT 0", nullable = false)
    private Long views = 0L;
    @Column(name = "createdAt", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void setDate(){
        this.createdAt = LocalDateTime.now();
    }

}
