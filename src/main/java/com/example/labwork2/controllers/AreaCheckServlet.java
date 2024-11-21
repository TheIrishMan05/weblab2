package com.example.labwork2.controllers;


import com.example.labwork2.models.Point;
import com.example.labwork2.models.PointDao;
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
import java.util.Arrays;
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
                log.warn("Полученные данные не валидны. Промах гарантирован!");
            }
        } catch (Exception e) {
            log.error("Ошибка обработки запроса", e);
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input");
            return;
        }
        Objects.requireNonNull(point).setHit(checker.checkArea(point));

        log.info("Обработка точки: {}", point);
        HttpSession session = req.getSession();
        PointDao pointsBean = (PointDao) session.getAttribute("pointsBean");
        if (pointsBean == null) {
            pointsBean = new PointDao();
        }
        pointsBean.insert(point);
        session.setAttribute("pointsBean", pointsBean);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new ObjectMapper().writeValueAsString(point));
        log.info("Object of point was sent back: {}", point.toString());
    }

    private boolean validateParams(Point point) {
        int[] arrayR = {1, 2, 3, 4, 5};
        if (Arrays.stream(arrayR).noneMatch(r -> r == point.getR())) {
            return false;
        } else if (point.getX() < -point.getR() || point.getX() > point.getR()) {
            return false;
        } else return !(point.getY() < -point.getR()) && !(point.getY() > point.getR());
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
