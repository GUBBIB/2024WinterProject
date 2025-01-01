package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.User;
import WinterProject.WinterProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController{
    @Autowired
    private UserService userService;

    // 사용자 저장
    @PostMapping("/register/saveUser")
    public String save(User user, Model model){
        try {
            userService.saveUser(user);
        } catch(Exception e){
            model.addAttribute("error", e.toString());
            return "error";
        }
        return "redirect:/";
    }

    // 로그인 기능
    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String password){
        if(!userService.chkUser(userId, password)){
            return "error";
        }
        return "redirect/mainPage";
    }



    @GetMapping("/chk")
    public String chk(){
        return "chk";
    }
}