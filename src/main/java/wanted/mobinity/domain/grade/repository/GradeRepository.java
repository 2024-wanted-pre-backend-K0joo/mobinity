package wanted.mobinity.domain.grade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.mobinity.domain.grade.domain.Grade;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    Optional<Grade> findByName(String name); // 이름으로 찾기
}
