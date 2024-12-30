package WinterProject.WinterProject.Service;

import WinterProject.WinterProject.Entity.User;
import WinterProject.WinterProject.Form.UserForm;
import WinterProject.WinterProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void userSave(UserForm form){
        User user = form.toEntity();
        userRepository.save(user);
    }
}
