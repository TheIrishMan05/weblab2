package com.example.labwork2.utils;

import com.example.labwork2.models.Point;


public class AreaChecker {
    public boolean checkArea(Point point) {
        if (point.getX() <= 0 && point.getY() <= 0) {
            return checkRectangle(point);
        } else if (point.getX() > 0 && point.getY() >= 0) {
            return checkCircle(point);
        } else if (point.getX() <= 0 && point.getY() > 0) {
            return checkTriangle(point);
        } else {
            return false;
        }
    }

    private boolean checkTriangle(Point point) {
        return point.getX() >= -point.getR() && point.getY() <= point.getR() && -point.getX() - point.getY() <= point.getR();
    }

    private boolean checkRectangle(Point point) {
        return point.getX() >= -point.getR() && point.getY() <= -point.getR() / 2;
    }

    private boolean checkCircle(Point point) {
        return Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) <= Math.pow(point.getR(), 2);
    }
}
