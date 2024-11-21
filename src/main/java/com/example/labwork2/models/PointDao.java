package com.example.labwork2.models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@SessionScoped
@Named
@EqualsAndHashCode
@ToString
public class PointDao implements Dao<Point>, Serializable {
    private final List<Point> points = new ArrayList<>();
    @Override
    public void insert(Point point) {
        points.add(point);
    }
}
