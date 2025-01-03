package WinterProject.WinterProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MoveController {
    @GetMapping("/register")
    public String goToRegisterPage(){
        return "RegisterPage";
    }

    @GetMapping("/login")
    public String goToLoginPage(){
        return "LoginPage";
    }
}
