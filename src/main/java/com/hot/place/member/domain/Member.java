package com.hot.place.member.domain;

import com.hot.place.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Data @EqualsAndHashCode(callSuper = false)
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
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

    @Embedded
    private Point point = new Point();

    @Builder
    public Member(long id, @NonNull String name, @NonNull String email, @NonNull String password, int point) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.point = new Point(point);
    }

    public int getPoint() {
        return this.point.getPoint();
    }

    public void addPoint(int point) {
        this.point.addPoint(point);
    }
}