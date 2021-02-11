package com.hot.place.member.domain;

import com.hot.place.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Data @EqualsAndHashCode(callSuper = false)
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class Member extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;
}