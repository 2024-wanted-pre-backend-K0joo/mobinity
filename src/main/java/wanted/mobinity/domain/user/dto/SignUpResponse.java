package wanted.mobinity.domain.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wanted.mobinity.domain.grade.domain.Grade;
import wanted.mobinity.domain.user.domain.User;

import java.util.Date;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpResponse {
    private UUID userId;
    private String account;
    private String password;
    private String name;
    private Date createdAt;
    private Grade grade;

    public SignUpResponse(User user){
        this.userId = user.getUserId();
        this.account = user.getAccount();
        this.password = user.getPassword();
        this.name = user.getName();
        this.createdAt = user.getCreatedAt();
        this.grade = user.getGrade();
    }
}
