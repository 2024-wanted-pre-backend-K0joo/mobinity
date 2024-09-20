package wanted.mobinity.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.mobinity.domain.user.domain.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByAccount(String account);
}
