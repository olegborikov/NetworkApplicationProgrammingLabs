<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Объем параллелепипеда</title>
</head>
<body>
<p>
    Вычисление объема параллелепипеда:
</p>
<form method="post" action="controller" autocomplete="off">
    <label>
        Ребро a:
        <input type="text" name="sideA"/>
    </label>
    <br>
    <label>
        Ребро b:
        <input type="text" name="sideB"/>
    </label>
    <br>
    <label>
        Ребро c:
        <input type="text" name="sideC"/>
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
    <button name="commandName" value="calculate_parallelepiped_volume_command">
        Вычислить
    </button>
</form>
</body>
</html>
