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
    @JoinColumn(name = "postIdF", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post postIdF;
    @ManyToOne
    @JoinColumn(name = "userIdF", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User userIdF;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(name = "createdAt", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void setDate(){
        this.createdAt = LocalDateTime.now();
    }
}
