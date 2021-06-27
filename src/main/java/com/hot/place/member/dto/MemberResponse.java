package com.hot.place.member.dto;

import com.hot.place.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter @NoArgsConstructor
public class MemberResponse {
    private long id;
    private String name;
    private String email;
    private String password;
    private int point;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public MemberResponse(long id, String name, String email, String password, int point, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.point = point;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public static MemberResponse of(Member member) {
        return new MemberResponse(member.getId(), member.getName(), member.getEmail(), member.getPassword(),
                    member.getPoint(), member.getCreatedDate(), member.getModifiedDate());
    }
}
