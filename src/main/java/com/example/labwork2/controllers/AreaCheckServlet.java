package com.example.labwork2.controllers;


import com.example.labwork2.models.Point;
import com.example.labwork2.utils.AreaChecker;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/areaCheck")
@Log4j2
public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Point point;
        AreaChecker checker = new AreaChecker();
        try {
            point = parseRequest(req);
            if (point == null || !validateParams(point)) {
                log.warn("Полученные данные не валидны.");
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            log.error("Ошибка обработки запроса", e);
            resp.sendError(400, "Invalid input");
            return;
        }
        Objects.requireNonNull(point).setHit(checker.checkArea(point));

        log.info("Обработка точки: {}", point);
        HttpSession session = req.getSession();
        List<Point> points = (List<Point>) session.getAttribute("points");
        if (points == null) {
            points = new ArrayList<>();
        }
        points.add(point);
        session.setAttribute("points", points);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new ObjectMapper().writeValueAsString(point));
        log.info("Object of point was sent back: {}", point.toString());
    }

    private boolean validateParams(Point point) {
        return validateX(point) && validateY(point) && validateR(point);
    }

    private boolean validateY(Point point) {
        return point.getY() >= -point.getR() && point.getY() <= point.getR()
                && point.getY() <= 5 && point.getY() >= -3;
    }

    private boolean validateX(Point point) {
        return point.getX() >= -point.getR() && point.getX() <= point.getR()
                && point.getX() <= 4 && point.getX() >= -4;
    }

    private boolean validateR(Point point) {
        return point.getR() >= 1 && point.getR() <= 5;
    }

    private Point parseRequest(HttpServletRequest request)
            throws NumberFormatException, IOException {
        StringBuilder builder = new StringBuilder();
        String line;

        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }

        String json = builder.toString();

        return new ObjectMapper().readValue(json, Point.class);
    }
}
