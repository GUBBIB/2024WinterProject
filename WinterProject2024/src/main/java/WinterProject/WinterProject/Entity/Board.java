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
    private Long board_id;
    @Column(length = 255, nullable = false)
    private String board_name;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String board_description;
}
