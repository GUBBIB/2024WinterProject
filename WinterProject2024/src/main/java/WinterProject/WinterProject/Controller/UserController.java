package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.User;
import WinterProject.WinterProject.Form.UserForm;
import WinterProject.WinterProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register/save")
    public String save(UserForm form, Model model){
        try {
            User user = form.toEntity();
            User saved = userRepository.save(user);
        } catch(Exception e){
            model.addAttribute("error", e.toString());
            return "redirect:error";
        }
        return "redirect:chk";
    }
}
