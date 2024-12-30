package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.User;
import WinterProject.WinterProject.Service.UserService;
import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FirstController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String goToRegister(){
        return "register";
    }

    @PostMapping("/register/save")
    public String save(User user, Model model){
        try {
            userService.userSave(user);
        } catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "redirect:error";
        }
        return "redirect:/";
    }
}
