package WinterProject.WinterProject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardId")
    private Long boardId;
    @Column(name = "boardName", length = 255, nullable = false)
    private String boardName;
    @Column(name = "boardDescription", columnDefinition = "TEXT", nullable = false)
    private String boardDescription;

    @OneToMany(mappedBy = "boardIdFP", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();
    @OneToMany(mappedBy = "boardIdFC", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();
}
