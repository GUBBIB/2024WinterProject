package WinterProject.WinterProject.Service;

import WinterProject.WinterProject.Entity.User;
import WinterProject.WinterProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean chkUser(String user_id, String password) {
        Optional<User> optionalUser = userRepository.findById(user_id);

        if (optionalUser.isEmpty()) {
            return false;
        }

        User user = optionalUser.get();
        if(!password.equals(user.getPassword())){
            return false;
        }

        return true;
    }
}
