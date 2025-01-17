package WinterProject.WinterProject.Repository;

import WinterProject.WinterProject.Entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UserRepository extends CrudRepository<Users, String> {
    Optional<Users> findByUserId(String userId);

}
