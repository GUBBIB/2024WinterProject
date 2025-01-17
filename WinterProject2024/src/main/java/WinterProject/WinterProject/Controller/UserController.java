package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.Users;
import WinterProject.WinterProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController{
    @Autowired
    private UserService userService;
    @Autowired //암호화위해서 사용
    private PasswordEncoder passwordEncoder;

    // 사용자 저장
    @PostMapping("/register/saveUsers")
    public String save(Users users, Model model){
        try {
            String encodedPassword = passwordEncoder.encode(users.getPassword());
            users.setPassword(encodedPassword);
            userService.saveUser(users);
        } catch(Exception e){
            model.addAttribute("error", e.toString());
            return "error";
        }
        return "redirect:/";
    }

    // 로그인 기능 스프링 부트로 대체 예정
//    @PostMapping("/login")
//    public String login(@RequestParam String userId, @RequestParam String password){
//        if(!userService.chkUser(userId, password)){
//            return "error";
//        }
//        return "redirect:/";
//    }

    @GetMapping("/chk")
    public String chk(){
        return "chk";
    }
}