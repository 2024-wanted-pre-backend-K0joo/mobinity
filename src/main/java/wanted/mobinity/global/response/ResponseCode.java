package wanted.mobinity.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ResponseCode Convention
 * - 도메인 별로 나누어 관리
 * - [동사_목적어_SUCCESS] 형태로 생성
 * - 코드는 도메인명 앞에서부터 1~2글자로 사용
 * - 메시지는 "~~다."로 마무리
 */

@Getter
@AllArgsConstructor
public enum ResponseCode {
    // User
    LOGIN_SUCCESS(200, "U001", "로그인에 성공하였습니다."),
    LOGIN_FAIL(200, "U002", "로그인에 실패하였습니다."),
    REGISTER_SUCCESS(200, "U003", "회원가입에 성공하였습니다."),
    // User 추가 기능
    // EDIT_PROFILE_SUCCESS(200, "U004", "회원 프로필을 수정하였습니다."),
    // GET_USERPROFILE_SUCCESS(200, "U005", "회원 프로필을 조히하였습니다."),
    // SAVE_PROFILE_SUCCESS(200, "U006", "회원 프로필을 저장하였습니다."),
    // DELETE_SUCCESS(200, "U007", "회원 탈퇴에 성공하였습니다."),
    // DELETE_FAIL(200, "U08", "회원 탈퇴에 실패하였습니다"),
    // CHECK_TOKEN_SUCCESS(200, "U009", "유효한 토큰입니다."),
    // CHECK_TOKEN_FAIL(200, "U010", "만료된 토큰입니다."),

    // Brand
    CREATE_BRAND_SUCCESS(200, "B001", "브랜드가 생성되었습니다."),
    // Brand 추가 기능
    // UPDATE_BRAND_SUCCESS(200, "B002", "브랜드가 수정되었습니다."),
    // DEKETE_BRAND_SUCCESS(200, "B003", "브랜드가 삭제되었습니다."),

    // Product
    GET_ALL_PRODUCT_SUCCESS(200, "P001", "전체 상품이 조회가 성공하였습니다."),
    GET_BRAND_FILTER_PRODUCT_SUCCESS(200, "P002", "브랜드로 필터링한 상품 조회가 성공하였습니다."),
    // Product 추가 기능
    // CREATE_PRODUCT_SUCCESS(200, "P003", "상품이 등록되었습니다."),
    // GET_ONE_PRODUCT_SUCCESS(200, "P004", "상품 상세 조회가 성공하였습니다."),
    // GET_SCRAP_PRODUCT_SUCCESS(200, "P005", "자신이 스크랩한 상품 조회가 성공하였습니다."),
    // UPDATE_PRODUCT_SUCCESS(200, "P006", "상품이 수정되었습니다."),
    // DELETE_PRODUCT_SUCCESS(200, "P007", "상품이 삭제되었습니다."),
    // UPDATE_SCRAP_FEED_SUCCESS(200, "P008", "해당 상품을 스크랩하였습니다."),
    // UPDATE_UNSCRAP_FEED_SUCCESS(200, "P009", "해당 상품을 스크랩 취소하였습니다."),
    ;

    private final int status;
    private final String code;
    private final String message;

}
