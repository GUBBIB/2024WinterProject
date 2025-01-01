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
    @Column(name = "board_id")
    private Long board_id;
    @Column(name = "board_name", length = 255, nullable = false)
    private String board_name;
    @Column(name = "board_description", columnDefinition = "TEXT", nullable = false)
    private String board_description;
}
