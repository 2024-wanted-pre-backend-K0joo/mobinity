package wanted.mobinity.domain.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wanted.mobinity.domain.user.dto.SignInRequest;
import wanted.mobinity.domain.user.dto.SignInResponse;
import wanted.mobinity.domain.user.dto.SignUpRequest;
import wanted.mobinity.domain.user.dto.SignUpResponse;
import wanted.mobinity.domain.user.service.UserService;
import wanted.mobinity.global.response.ResponseCode;
import wanted.mobinity.global.response.ResponseDto;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor // 생성자 자동 생성
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signUp(@Valid @RequestBody SignUpRequest signUpRequest){
        SignUpResponse result = userService.signUp(signUpRequest);

        return ResponseEntity.ok(ResponseDto.of(ResponseCode.REGISTER_SUCCESS, result));
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseDto> login(@RequestBody SignInRequest signInRequestDto){
        SignInResponse user = userService.login(signInRequestDto.getAccount(), signInRequestDto.getPassword());
        return ResponseEntity.ok(ResponseDto.of(ResponseCode.LOGIN_SUCCESS, user));
    }
}
