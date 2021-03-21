package com.hot.place.member.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Embeddable
@EqualsAndHashCode
public class Point {
    @Column
    private int point;

    protected Point() {

    }

    public Point(int point) {
        this.point = point;
    }

    public static Point of(int point) {
        return new Point(point);
    }

    public int getPoint() {
        return point;
    }

    public Point addPoint(Point addPoint) {
        return Point.of(point + addPoint.point);
    }

    public Point subtractPoint(Point subtractPoint) {
        return Point.of(point - subtractPoint.point);
    }
}
