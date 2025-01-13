package WinterProject.WinterProject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {
    @Id
    @Column(name = "userId", unique = true)
    private String userId;
    @Column(length = 100)
    private String email;
    @Column(length = 255)
    private String password;
    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "userIdF", cascade = CascadeType.ALL)
    private List<Post> posts;
    @OneToMany(mappedBy = "userIdF", cascade = CascadeType.ALL)
    private List<Comment> comments;
    
    public User() {}

    public User(String userId, String email, String password, String name) {
        this.userId = userId; this.email = email;
        this.password = password; this.name = name;
    }

    public String toString(){
        return String.format("ID : %s email : %s password : %s name: %s\n", this.userId, this.email, this.password, this.name);
    }
}
