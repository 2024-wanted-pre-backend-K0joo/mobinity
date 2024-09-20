package wanted.mobinity.domain.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wanted.mobinity.domain.user.domain.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignInResponse {
    private String account;
    private String name; // 필요 시 다른 사용자 정보를 추가할 수 있습니다.

    public SignInResponse(User user) {
        this.account = user.getAccount();
        this.name = user.getName();
    }
}
