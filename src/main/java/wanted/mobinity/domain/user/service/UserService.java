package wanted.mobinity.domain.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wanted.mobinity.domain.grade.domain.Grade;
import wanted.mobinity.domain.grade.repository.GradeRepository;
import wanted.mobinity.domain.user.domain.User;
import wanted.mobinity.domain.user.dto.SignInResponse;
import wanted.mobinity.domain.user.dto.SignUpRequest;
import wanted.mobinity.domain.user.dto.SignUpResponse;
import wanted.mobinity.domain.user.repository.UserRepository;
import wanted.mobinity.global.error.ErrorCode;
import wanted.mobinity.global.error.exception.EntityAlreadyExistException;
import wanted.mobinity.global.error.exception.EntityNotFoundException;
import wanted.mobinity.global.error.exception.InvalidPasswordException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final GradeRepository gradeRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignUpResponse signUp(SignUpRequest signUpRequest){
        log.info("회원가입 요청: {}", signUpRequest);

        // 아이디 중복 확인
        if(userRepository.findByAccount(signUpRequest.getAccount()).isPresent()){
            throw new EntityAlreadyExistException(ErrorCode.ACCOUNT_ALEREADY_EXIST);
        }

        // 기본 회원 등급을 가져옴
        // 회원 등급은 Beginner, Basic, Superb, VIP, VVIP로 구성됨
        Grade defaultGrade = gradeRepository.findByName("Beginner")
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 등급입니다."));

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());

        // 새로운 User 생성
        User newUser = User.builder()
                .account(signUpRequest.getAccount())
                .password(encodedPassword)
                .name(signUpRequest.getName())
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .grade(defaultGrade)
                .build();
        // 저장
        userRepository.save(newUser);

        log.info("회원가입 성공: {}", newUser.getAccount());

        // 응답 DTO로 변환 후 반환
        return new SignUpResponse(newUser);
    }

    @Transactional
    public SignInResponse login(String account, String password) {
        User user = userRepository.findByAccount(account)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.USER_NOT_FOUND));

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new InvalidPasswordException(ErrorCode.PASSWORD_MISMATCH);
        }

        return new SignInResponse(user);
    }
}
