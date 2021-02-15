package com.hot.place.member.dto;

import com.hot.place.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter @NoArgsConstructor @AllArgsConstructor
public class MemberResponse {
    private long id;
    private String name;
    private String email;
    private String password;
    private int point;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static MemberResponse of(Member member) {
        return new MemberResponse(member.getId(), member.getName(), member.getEmail(), member.getPassword(), member.getPoint(),
                                    member.getCreatedDate(), member.getModifiedDate());
    }
}
