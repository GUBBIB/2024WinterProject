package WinterProject.WinterProject.Repository;

import WinterProject.WinterProject.Entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByUserId(String user_id);

}
