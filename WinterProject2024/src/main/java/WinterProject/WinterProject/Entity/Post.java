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
    @Column(name = "post_id")
    private Long post_id;
    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board_idF;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User userIdF;
    @Column(length = 255, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(columnDefinition = "BIGINT DEFAULT 0", nullable = false)
    private Long views = 0L;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime created_at;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at;

    @PrePersist
    protected void setDate(){
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }
    @PreUpdate
    protected void updateDate(){
        this.updated_at = LocalDateTime.now();
    }
}
