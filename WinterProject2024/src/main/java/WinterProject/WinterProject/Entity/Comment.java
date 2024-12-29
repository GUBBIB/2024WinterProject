package WinterProject.WinterProject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Post post_id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user_id;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(updatable = false, nullable = false)
    private LocalDateTime created_at;
    @Column(nullable = false)
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
