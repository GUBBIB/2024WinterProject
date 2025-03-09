package WinterProject.WinterProject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    private Long commentId;
    @ManyToOne
    @JoinColumn(name = "postIdFC", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post postIdFC;
    @ManyToOne
    @JoinColumn(name = "userIdFC", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users userIdFC;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(name = "createdAt", updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "boardIdFC", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Board boardIdFC;

    @PrePersist
    protected void setDate(){
        this.createdAt = LocalDateTime.now();
    }

}
