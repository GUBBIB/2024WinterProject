package WinterProject.WinterProject.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MoveController {
    @GetMapping("/")
    public String goToHome(){
        return "index";
    }

    @GetMapping("/register")
    public String goToRegisterPage(){
        return "RegisterPage";
    }

    @GetMapping("/loginPage")
    public String goToLoginPage(){
        return "LoginPage";
    }

    @GetMapping("/ChatRoomPage")
    public String goToChatRoom(){
        return "ChatRoomPage";
    }
}
