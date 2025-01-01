package WinterProject.WinterProject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long comment_id;
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post_idF;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User userIdF;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
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
