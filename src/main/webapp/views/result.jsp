<%@ page import="com.example.labwork2.models.Point" %>
<%@ page import="java.util.List" %>
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
<div id="input-container">
<table id = "output-table">
    <thead>
    <tr>
        <th>X</th>
        <th>Y</th>
        <th>R</th>
        <th>Result</th>
        <th>Current time</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Point> points = (List<Point>) request.getSession().getAttribute("allPoints");
        if (points == null) {
    %>
    <tr id="no-data">
        Нет данных
    </tr>
    <%
    } else {
        for(Point point : points) {
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
</div>
</body>
<script type="text/javascript">
    <%@include file="../scripts/script.js" %>
</script>
</html>