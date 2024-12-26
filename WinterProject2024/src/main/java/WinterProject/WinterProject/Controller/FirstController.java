package WinterProject.WinterProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/register")
    public String goToRegister(){
        return "register";
    }
}
