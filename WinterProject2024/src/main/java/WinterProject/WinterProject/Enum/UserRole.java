package WinterProject.WinterProject.Enum;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ROLE_Admin"),
    USER("ROLE_User");

    private String value;

    UserRole(String value){
        this.value = value;
    }
}
