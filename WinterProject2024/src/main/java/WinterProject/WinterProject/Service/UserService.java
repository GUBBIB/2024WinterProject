package WinterProject.WinterProject.Service;

import WinterProject.WinterProject.Entity.Users;
import WinterProject.WinterProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void saveUser(Users users) {
        userRepository.save(users);
    }

    public boolean chkUser(String userId, String password) {
        Optional<Users> optionalUser = userRepository.findByUserId(userId);

        if (!optionalUser.isPresent()) {
            return false;
        }
        Users users = optionalUser.get();
        if(!password.equals(users.getPassword())){
            return false;
        }

        return true;
    }

    public Users getUserByUserId(String userId){

        Users user = userRepository.findById(userId).get();

        return user;
    }
}
