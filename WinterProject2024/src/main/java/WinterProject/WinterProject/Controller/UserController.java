package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.User;
import WinterProject.WinterProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController{
    @Autowired
    private UserService userService;

    @PostMapping("/register/save")
    public String save(User user, Model model){
        try {
            userService.saveUser(user);
        } catch(Exception e){
            model.addAttribute("error", e.toString());
            return "redirect:/error";
        }
        return "redirect:/chk";
    }

    @GetMapping("/register/error")
    public String erorr(){
        return "error";
    }

    @GetMapping("/register/chk")
    public String chk(){
        return "chk";
    }
}