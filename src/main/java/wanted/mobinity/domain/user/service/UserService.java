package wanted.mobinity.domain.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wanted.mobinity.domain.grade.domain.Grade;
import wanted.mobinity.domain.grade.repository.GradeRepository;
import wanted.mobinity.domain.user.domain.User;
import wanted.mobinity.domain.user.dto.UserSignUpDto;
import wanted.mobinity.domain.user.dto.UserSignUpResponseDto;
import wanted.mobinity.domain.user.repository.UserRepository;
import wanted.mobinity.global.error.ErrorCode;
import wanted.mobinity.global.error.exception.EntityAlreadyExistException;
import wanted.mobinity.global.error.exception.EntityNotFoundException;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final GradeRepository gradeRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserSignUpResponseDto signUp(UserSignUpDto userSignUpDto){
        log.info("회원가입 요청: {}", userSignUpDto);

        // 아이디 중복 확인
        if(userRepository.findByAccount(userSignUpDto.getAccount()).isPresent()){
            throw new EntityAlreadyExistException(ErrorCode.ACCOUNT_ALEREADY_EXIST);
        }

        // 기본 회원 등급을 가져옴
        // 회원 등급은 Beginner, Basic, Superb, VIP, VVIP로 구성됨
        Grade defaultGrade = gradeRepository.findByName("Beginner")
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.BRAND_NOT_FOUND));

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userSignUpDto.getPassword());

        // 새로운 User 생성
        User newUser = User.builder()
                .account(userSignUpDto.getAccount())
                .password(encodedPassword)
                .name(userSignUpDto.getName())
                .createdAt(new Date())
                .grade(defaultGrade)
                .build();
        // 저장
        userRepository.save(newUser);

        log.info("회원가입 성공: {}", newUser.getAccount());

        // 응답 DTO로 변환 후 반환
        return new UserSignUpResponseDto(newUser);
    }
}
