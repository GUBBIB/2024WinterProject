package WinterProject.WinterProject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(length = 100)

    private String email;
    @Column(length = 255)
    private String password;
    @Column(length = 50)
    private String name;
    @Column
    private String role;
}
