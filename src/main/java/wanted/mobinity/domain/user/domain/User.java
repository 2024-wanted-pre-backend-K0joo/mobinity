package wanted.mobinity.domain.user.domain;

import jakarta.persistence.*;
import lombok.*;
import wanted.mobinity.domain.grade.domain.Grade;

import java.sql.Timestamp;
import java.util.UUID;

@Table(name = "users")
@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(nullable = false, unique = true)
    private String account;

    @Column(nullable = false)
    private String password;

    @Column
    private String name;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @Builder
    public User(String account, String password, String name, Timestamp createdAt, Grade grade) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.createdAt = createdAt;
        this.grade = grade;
    }
}
