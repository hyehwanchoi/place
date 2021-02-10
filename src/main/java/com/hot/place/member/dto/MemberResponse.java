package com.hot.place.member.dto;

import com.hot.place.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor @AllArgsConstructor
public class MemberResponse {
    private long id;
    private String name;
    private String email;
    private String password;

    public static MemberResponse of(Member member) {
        return new MemberResponse(member.getId(), member.getName(), member.getEmail(), member.getPassword());
    }
}
