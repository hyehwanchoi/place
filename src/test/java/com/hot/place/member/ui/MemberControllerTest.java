package com.hot.place.member.ui;

import com.hot.place.AcceptanceTest;
import com.hot.place.member.dto.MemberRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class MemberControllerTest extends AcceptanceTest {

    private MemberRequest memberRequest;

    @BeforeEach
    void setup() {
        memberRequest = MemberRequest.builder()
                                    .name("최혜환")
                                    .email("chh9975@naver.com")
                                    .password("1234").build();
    }

    @Test
    void insertTest() {
        // when
        ExtractableResponse<Response> response = 회원_추가_요청(memberRequest);

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void getTest() {
        // given
        회원_추가_요청(memberRequest);

        // when
        ExtractableResponse<Response> response = 모든_회원_조회_요청();

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    private ExtractableResponse<Response> 회원_추가_요청(MemberRequest memberRequest) {
        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(memberRequest)
                .when().post("/member")
                .then().log().all()
                .extract();

    }

    private ExtractableResponse<Response> 모든_회원_조회_요청() {
        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/member")
                .then().log().all()
                .extract();
    }
}