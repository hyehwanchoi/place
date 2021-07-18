package com.hot.place.member.ui;

import com.hot.place.AcceptanceTest;
import com.hot.place.member.dto.MemberRequest;
import com.hot.place.member.dto.MemberResponse;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("회원 관련 기능")
class MemberControllerTest extends AcceptanceTest {

    private MemberRequest memberRequest1;
    private MemberRequest memberRequest2;

    @BeforeEach
    void setup() {
        memberRequest1 = MemberRequest.builder()
                                    .name("최혜환")
                                    .email("chh9975@naver.com")
                                    .password("1234").build();
        memberRequest2 = MemberRequest.builder()
                            .name("김수연")
                            .email("suyn1121@naver.com")
                            .password("1234").build();
    }

    @Test
    void insertMember() {
        // when
        ExtractableResponse<Response> response = MemberUtil.회원_추가_요청(memberRequest1);

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void insertManyMember() {
        List<MemberRequest> memberRequestList = new ArrayList<>();
        memberRequestList.add(memberRequest1);
        memberRequestList.add(memberRequest2);

        ExtractableResponse<Response> response;
        for (MemberRequest request : memberRequestList) {
            MemberUtil.회원_추가_요청(request);
        }

//        assertThat(MemberUtil.모든_회원_조회_요청().).isEqualTo()
    }

    @Test
    void getAllMember() {
        // given
        MemberUtil.회원_추가_요청(memberRequest1);

        // when
        ExtractableResponse<Response> response = MemberUtil.모든_회원_조회_요청();

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void getMember() {
        // given
        ExtractableResponse<Response> createResponse = MemberUtil.회원_추가_요청(memberRequest1);

        // when
        ExtractableResponse<Response> response = MemberUtil.회원_조회_요청(createResponse.as(MemberResponse.class).getId());

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void getBasePoint() {
        // gvien
        ExtractableResponse<Response> createResponse = MemberUtil.회원_추가_요청(memberRequest1);

        assertThat(createResponse.jsonPath().getObject(".", MemberResponse.class).getPoint()).isEqualTo(0);
    }

//    @Test
//    void addPoint() {
//        // gvien
//        ExtractableResponse<Response> createResponse = MemberUtil.회원_추가_요청(memberRequest1);
//
//        // when
//        ExtractableResponse<Response> response = MemberUtil.회원_포인트_추가_요청(createResponse.as(MemberResponse.class).getId(), 2);
//
//        // then
//        assertAll(
//            () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value()),
//            () -> assertThat(response.jsonPath().getObject(".", MemberResponse.class).getPoint()).isEqualTo(2)
//        );
//    }

    @Test
    void getPoint() {
        // gvien
        ExtractableResponse<Response> createResponse1 = MemberUtil.회원_추가_요청(memberRequest1);
        ExtractableResponse<Response> createResponse2 = MemberUtil.회원_추가_요청(memberRequest2);
        MemberUtil.회원_포인트_추가_요청(createResponse1.as(MemberResponse.class).getId(), 2);
        MemberUtil.회원_포인트_추가_요청(createResponse1.as(MemberResponse.class).getId(), 4);
        MemberUtil.회원_포인트_추가_요청(createResponse2.as(MemberResponse.class).getId(), 3);

        // when
        ExtractableResponse<Response> response1 = MemberUtil.회원_조회_요청(createResponse1.jsonPath().getObject(".", MemberResponse.class).getId());
        ExtractableResponse<Response> response2 = MemberUtil.회원_조회_요청(createResponse2.jsonPath().getObject(".", MemberResponse.class).getId());

        // then
        assertAll(
                () -> assertThat(response1.jsonPath().getObject(".", MemberResponse.class).getPoint()).isEqualTo(6),
                () -> assertThat(response2.jsonPath().getObject(".", MemberResponse.class).getPoint()).isEqualTo(3)
        );
    }
}