package WinterProject.WinterProject.Service;

import WinterProject.WinterProject.Entity.Users;
import WinterProject.WinterProject.Enum.UserRole;
import WinterProject.WinterProject.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserSecurityService.class);
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        Optional<Users> _user = this.userRepository.findByUserId(userId);

        Users user = _user.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        logger.info("UserRole: {}", user.getRole());

        if (UserRole.ADMIN.equals(user.getRole())) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }

        return new User(user.getUserId(), user.getPassword(), authorities);
    }
}
