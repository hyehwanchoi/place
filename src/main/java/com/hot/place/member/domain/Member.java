package com.hot.place.member.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class Member {
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