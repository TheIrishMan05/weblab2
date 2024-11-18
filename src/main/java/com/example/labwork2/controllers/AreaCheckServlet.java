package com.example.labwork2.controllers;


import com.example.labwork2.models.Point;
import com.example.labwork2.utils.AreaChecker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@WebServlet("/areaChecker")
@Log4j2
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Point point;
        AreaChecker checker = new AreaChecker();
        try {
            point = parseRequest(req);
            if (point == null || !validateParams(point)) {
                log.warn("Некорректные данные или отсутствие координат точки");
                req.getRequestDispatcher("views/index.jsp").forward(req, resp);
                return;
            }
        } catch (JsonProcessingException | NumberFormatException e) {
            log.error("Ошибка обработки запроса", e);
            req.getRequestDispatcher("views/index.jsp").forward(req, resp);
            return;
        }

        log.info("Обработка точки: {}", point);

        Objects.requireNonNull(point).setHit(checker.checkArea(point));

        HttpSession session = req.getSession();

        ObjectMapper mapper = new ObjectMapper();

        String json = (String) session.getAttribute("allPoints");

        List<Point> points = mapper.readValue(json, new TypeReference<>() {});

        session.setAttribute("allPoints", mapper.writeValueAsString(points));

        req.setAttribute("point", point);

        req.getRequestDispatcher("views/result.jsp").forward(req, resp);
    }

    private boolean validateParams(Point point) {
        ArrayList<Integer> listR = (ArrayList<Integer>) Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        if (listR.stream().noneMatch(r -> r == point.getR())) {
            return false;
        } else if (point.getX() < -point.getR() || point.getX() > point.getR()) {
            return false;
        } else return !(point.getY() < -point.getR()) && !(point.getY() > point.getR());
    }

    private Point parseRequest(HttpServletRequest request)
            throws NumberFormatException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder builder = new StringBuilder();
        String line;

        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }

        String json = builder.toString();

        return mapper.readValue(json, Point.class);
    }
}
