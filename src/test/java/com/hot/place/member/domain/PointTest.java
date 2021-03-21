package com.hot.place.member.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("포인트 관련 기능")
class PointTest {

    @Test
    void create() {
        Point point = new Point(2);
        assertThat(point).isEqualTo(Point.of(2));
    }

    @Test
    void addPoint() {
        Point point = new Point(2);
        assertThat(point.addPoint(Point.of(2))).isEqualTo(Point.of(4));
    }

    @Test
    void subtractPoint() {
        Point point = new Point(4);

        assertAll(
                () -> assertThat(point.subtractPoint(Point.of(2))).isEqualTo(Point.of(2)),
                () -> assertThat(point.getPoint()).isEqualTo(4)
        );
    }
}