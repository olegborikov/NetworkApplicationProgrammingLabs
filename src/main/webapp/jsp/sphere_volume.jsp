<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Объем сферы</title>
</head>
<body>
<p>
    Вычисление объема сферы:
</p>
<form method="post" action="controller" autocomplete="off">
    <label>
        Радиус:
        <input type="text" name="radius"/>
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
    <button name="commandName" value="calculate_sphere_volume_command">
        Вычислить
    </button>
</form>
</body>
</html>
