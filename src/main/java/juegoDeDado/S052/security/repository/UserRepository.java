package juegoDeDado.S052.security.repository;

import juegoDeDado.S052.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Long> {

    Optional<User> findByEmail(String email);
}
