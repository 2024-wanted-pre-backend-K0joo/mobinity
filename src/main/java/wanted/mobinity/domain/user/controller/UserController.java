package wanted.mobinity.domain.user.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wanted.mobinity.domain.user.dto.UserSignUpDto;
import wanted.mobinity.domain.user.dto.UserSignUpResponseDto;
import wanted.mobinity.domain.user.service.UserService;
import wanted.mobinity.global.response.ResponseCode;
import wanted.mobinity.global.response.ResponseDto;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signUp(@Valid @RequestBody UserSignUpDto userSignUpDto){
        UserSignUpResponseDto result = userService.signUp(userSignUpDto);

        return ResponseEntity.ok(ResponseDto.of(ResponseCode.REGISTER_SUCCESS, result));
    }
}
