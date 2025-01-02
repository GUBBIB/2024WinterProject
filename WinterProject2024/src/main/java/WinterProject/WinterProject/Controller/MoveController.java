package WinterProject.WinterProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MoveController {
    @GetMapping("/register")
    public String goToRegister(){
        return "register";
    }

    @GetMapping("/mainPage")
    public String goToMainPage(){
        return "mainPage";
    }
}
