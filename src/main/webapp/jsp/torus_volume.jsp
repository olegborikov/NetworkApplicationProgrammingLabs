<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Объем тора</title>
</head>
<body>
<p>
    Вычисление объема тора:
</p>
<form method="post" action="controller" autocomplete="off">
    <label>
        Радиус образующей окружности:
        <input type="text" name="radiusA"/>
    </label>
    <br>
    <label>
        Радиус вращения образующей окружности:
        <input type="text" name="radiusB"/>
    </label>
    <br>
    <label>
        Точность:
        <input type="text" name="accuracy"/>
    </label>
    <br>
    <c:if test="${incorrectData}">
        <div style="color: red">
            Введенные данные неверные
        </div>
    </c:if>
    <button name="commandName" value="calculate_torus_volume_command">
        Вычислить
    </button>
</form>
</body>
</html>
