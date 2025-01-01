package WinterProject.WinterProject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "Board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    @Column(length = 255, nullable = false)
    private String boardName;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String boardDescription;
}
