package wanted.mobinity.domain.grade.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "grade")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id", nullable = false)
    private Long gradeId;

    @Column(name = "grade_name", nullable = false, unique = true)
    private String name;

    @Column(name = "grade_discount_rate")
    private int discountRate;

    public Grade(String name, int discountRate){
        this.name = name;
        this.discountRate = discountRate;
    }
}
