package com.example.labwork2.models;

import jakarta.ejb.Stateful;
import jakarta.enterprise.context.SessionScoped;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@SessionScoped
@Stateful
public class PointDao implements Dao<Point>, Serializable {
    private final List<Point> points = new ArrayList<>();
    @Override
    public void insert(Point point) {
        points.add(point);
    }
}
