<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru-RU">
<head>
    <meta content="Машкин Григорий Андреевич" name="author">
    <meta content="Веб-программирование. Лабораторная работа №2" name="description">
    <style>
        <%@include file='../styles/index.css' %>
    </style>
    <title>Веб-программирование: Лабораторная работа №2</title>
</head>

<body>
<div class="page">
    <header>
        <div class="menu">
            <input class="burger-checkbox" id="burger-checkbox" type="checkbox">
            <label class="burger" for="burger-checkbox">
                <span></span>
            </label>
            <ul class="menu-list">
                <li><a class="menu-item" href="https://se.ifmo.ru/">Сайт ФПИиКТ ИТМО</a></li>
                <li><a class="menu-item" href="https://github.com/TheIrishMan05">Профиль на Github</a></li>
            </ul>
        </div>
        <div>
            <h2>Веб-программирование, Лабораторная работа №2, Вариант 409152</h2>
            <div id="credit">
                Машкин Григорий Андреевич, P3230
            </div>
        </div>
    </header>
    <div>
        <h3>Валидация введённых значений:</h3>
    </div>
    <div id="input-container">
        <div id="canvas-container">
            <canvas height="350px" id="myCanvas" width="350px"></canvas>
        </div>
        <div>
            <fieldset onchange="setValueX()">
                <legend>
                    Выберите значение X:
                </legend>
                <label>
                    <input class="illuminated animated" name="X-checkbox" type="checkbox" value="-4">
                    -4
                </label>
                <label>
                    <input class="illuminated animated" name="X-checkbox" type="checkbox" value="-3">
                    -3
                </label>
                <label>
                    <input class="illuminated animated" name="X-checkbox" type="checkbox" value="-2">
                    -2
                </label>
                <label>
                    <input class="illuminated animated" name="X-checkbox" type="checkbox" value="-1">
                    -1
                </label>
                <label>
                    <input class="illuminated animated" name="X-checkbox" type="checkbox" value="0">
                    0
                </label>
                <label>
                    <input class="illuminated animated" name="X-checkbox" type="checkbox" value="1">
                    1
                </label>
                <label>
                    <input class="illuminated animated" name="X-checkbox" type="checkbox" value="2">
                    2
                </label>
                <label>
                    <input class="illuminated animated" name="X-checkbox" type="checkbox" value="3">
                    3
                </label>
                <label>
                    <input class="illuminated animated" name="X-checkbox" type="checkbox" value="4">
                    4
                </label>
            </fieldset>

            <label for="y_input">
                Введите Y:
            </label><input id="y_input" maxlength="6" name="Y-input" placeholder="не менее -3 и не более 5" required
                           type="text">
            <label for="r-input">Выберите R:</label>
                <select id="r-input" onchange="setValueR()">
                    <option class="illuminated animated" id="r_1" name="R-option" value="1">
                        1
                    </option>
                    <option class="illuminated animated" id="r_2" name="R-option" value="2">
                        2
                    </option>
                    <option class="illuminated animated" id="r_3" name="R-option" value="3">
                        3
                    </option>
                    <option class="illuminated animated" id="r_4" name="R-option" value="4">
                        4
                    </option>
                    <option class="illuminated animated" id="r_5" name="R-option" value="5">
                        5
                    </option>
                </select>
            <div>
                <button id="check-button">Проверить данные</button>
            </div>
        </div>
        <div id="result-text"></div>
    </div>
</div>
<footer>
    2024
</footer>
</body>
<script type="text/javascript">
    <%@include file="../scripts/script.js" %>
</script>
</html>