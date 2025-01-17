package WinterProject.WinterProject.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class publicController {

    @ModelAttribute("username")
    public String getLoginUser(Authentication authentication){

        if(authentication != null && authentication.isAuthenticated()){
            return authentication.getName();
        }

        return null;
    }
}
