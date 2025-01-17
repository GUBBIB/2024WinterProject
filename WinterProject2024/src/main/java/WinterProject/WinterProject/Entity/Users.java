package WinterProject.WinterProject.Entity;

import WinterProject.WinterProject.Enum.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "userId", unique = true)
    private String userId;
    @Column(length = 100)
    private String email;
    @Column(length = 255)
    private String password;
    @Column(length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role = UserRole.ADMIN;

    @OneToMany(mappedBy = "userIdFP", cascade = CascadeType.ALL)
    private List<Post> posts;
    @OneToMany(mappedBy = "userIdFC", cascade = CascadeType.ALL)
    private List<Comment> comments;
    
    public Users() {}

    public Users(String userId, String email, String password, String name) {
        this.userId = userId; this.email = email;
        this.password = password; this.name = name;
    }

    public String toString(){
        return String.format("ID : %s email : %s password : %s name: %s\n", this.userId, this.email, this.password, this.name);
    }
}
