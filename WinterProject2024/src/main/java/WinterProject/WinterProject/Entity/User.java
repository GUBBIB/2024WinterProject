package WinterProject.WinterProject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 10)
    private String role;

    public String toString(){
        return String.format("ID : %d email : %s password : %s name: %s role : %s\n", this.user_id, this.email, this.password, this.name, this.role);
    }
}
