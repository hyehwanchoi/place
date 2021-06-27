package com.hot.place.member.domain;

import com.hot.place.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity @Getter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private int point;

    @Builder
    private Member(long id, @NonNull String name, @NonNull String email, @NonNull String password, int point) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.point = point;
    }

    public void addPoint(int point) {
        this.point += point;
    }
}