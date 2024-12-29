package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FirstController {
    @GetMapping("/register")
    public String goToRegister(){
        return "register";
    }


}
