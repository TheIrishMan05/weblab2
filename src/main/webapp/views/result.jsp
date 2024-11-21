<%@ page import="com.example.labwork2.models.PointDao" %>
<%@ page import="com.example.labwork2.models.Point" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta content="Машкин Григорий Андреевич" name="author">
    <meta content="Веб-программирование. Лабораторная работа №2. Результаты работы." name="description">
    <style>
        <%@include file='../styles/index.css' %>
    </style>
    <title>Веб-программирование: Лабораторная работа №2</title>
</head>
<body>
<table id = "output-table">
    <thead>
    <tr>
        <th>X</th>
        <th>Y</th>
        <th>R</th>
        <th>Result</th>
    </tr>
    </thead>
    <tbody>
    <%
        PointDao pointsBean = (PointDao) session.getAttribute("pointsBean");
        if (pointsBean == null || pointsBean.getPoints().isEmpty()) {
    %>
    <tr id="no-data">
        <td colspan="6">Нет данных</td>
    </tr>
    <%
        } else {
            for(Point point : pointsBean.getPoints()) {
    %>
    <tr>
        <td><%=String.format(Locale.US, "%.4f", point.getX())%></td>
        <td><%=String.format(Locale.US, "%.4f", point.getY())%></td>
        <td><%=String.format(Locale.US, "%.4f", point.getR())%></td>
        <td><%=point.isHit() ? "Есть пробитие" : "Нет пробития"%></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>