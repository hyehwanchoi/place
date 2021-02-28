package com.hot.place.member.dto;

import lombok.*;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class MemberRequest {
    private String name;
    private String email;
    private String password;
    private int point;
}
