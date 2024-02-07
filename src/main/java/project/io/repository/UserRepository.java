package project.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.io.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailOrPhone(String email, String phone);
}
