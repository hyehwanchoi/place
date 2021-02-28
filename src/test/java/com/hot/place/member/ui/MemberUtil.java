package com.hot.place.member.ui;

import com.hot.place.member.dto.MemberRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

@SuppressWarnings("NonAsciiCharacters")
public class MemberUtil {

    public static ExtractableResponse<Response> 회원_추가_요청(MemberRequest memberRequest) {
        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(memberRequest)
                .when().post("/member")
                .then().log().all()
                .extract();

    }

    public static ExtractableResponse<Response> 모든_회원_조회_요청() {
        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/member")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 회원_조회_요청(long id) {
        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/member/{id}", id)
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 회원_포인트_추가_요청(long id, int point) {
        return RestAssured
                .given().log().all()
                .when().put("/member/{id}/point?point={point}", id, point)
                .then().log().all()
                .extract();
    }
}
