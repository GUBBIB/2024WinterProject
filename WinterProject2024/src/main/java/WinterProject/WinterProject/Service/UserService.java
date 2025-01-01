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
    public void saveUser(User users) {
        userRepository.save(users);
    }

    public boolean chkUser(String userId, String password) {
        Optional<User> optionalUser = userRepository.findByUserId(userId);

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
