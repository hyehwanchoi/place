package com.hot.place.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable @Getter
@NoArgsConstructor
public class Point {
    private int point;

    public Point(int point) {
        this.point = point;
    }

    public void addPoint(int point) {
        this.point += point;
    }
}
