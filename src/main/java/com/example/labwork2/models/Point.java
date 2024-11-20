package com.example.labwork2.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Point {
    private double x;
    private double y;
    private double r;
    private boolean hit;

    @Override
    public String toString() {
        return "{x: " + x + ", y: " + y + ", r: " + r + ", isHit: " + hit + "}";
    }
}
