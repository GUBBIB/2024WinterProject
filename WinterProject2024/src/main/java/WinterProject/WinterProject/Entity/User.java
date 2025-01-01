package WinterProject.WinterProject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {
    @Id
    private String user_id;
    @Column(length = 100)
    private String email;
    @Column(length = 255)
    private String password;
    @Column(length = 50)
    private String name;
    // @Column(length = 10)
    // private String role;

    public User() {}

    public User(String user_id, String email, String password, String name) {
        this.user_id = user_id; this.email = email;
        this.password = password; this.name = name;
    }

    public String toString(){
        return String.format("ID : %s email : %s password : %s name: %s\n", this.user_id, this.email, this.password, this.name);
    }
}
