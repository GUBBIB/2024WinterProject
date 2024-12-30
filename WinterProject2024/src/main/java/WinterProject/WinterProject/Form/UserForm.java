package WinterProject.WinterProject.Form;

import WinterProject.WinterProject.Entity.User;

public class UserForm {
    private String user_id, email, password, name;

    public UserForm(String user_id, String email, String password, String name) {
        this.user_id = user_id; this.email = email;
        this.password = password; this.name = name;
    }

    public User toEntity(){
        return new User(user_id, email, password, name);
    }
}
