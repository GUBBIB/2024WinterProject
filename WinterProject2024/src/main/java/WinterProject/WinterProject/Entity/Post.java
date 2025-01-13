package WinterProject.WinterProject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    private Long postId;
    @ManyToOne
    @JoinColumn(name = "boardIdF", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Board boardIdF;
    @ManyToOne
    @JoinColumn(name = "userIdF", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User userIdF;
    @Column(length = 255, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(columnDefinition = "BIGINT DEFAULT 0", nullable = false)
    private Long views = 0L;
    @Column(name = "createdAt", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "postIdF", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @PrePersist
    protected void setDate(){
        this.createdAt = LocalDateTime.now();
    }

}
