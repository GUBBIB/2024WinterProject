package WinterProject.WinterProject.Controller;

import WinterProject.WinterProject.Entity.User;
import WinterProject.WinterProject.Form.UserForm;
import WinterProject.WinterProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController{
    @Autowired
    private UserService userService;

    @PostMapping("/register/save")
    public String save(UserForm form, Model model){
        try {
            userService.userSave(form);
        } catch(Exception e){
            model.addAttribute("error", e.toString());
            return "redirect:error";
        }
        return "redirect:/";
    }
}
