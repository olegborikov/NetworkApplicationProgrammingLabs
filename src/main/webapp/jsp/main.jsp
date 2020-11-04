<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Главная</title>
</head>
<body>
<p>
    Вычисление объема фигуры:
</p>
<div style="display: inline-block">
    <form method="post" action="controller">
        <button name="commandName" value="browse_parallelepiped_volume_page_command">
            Параллелепипед
        </button>
    </form>
</div>
<div style="display: inline-block">
    <form method="post" action="controller">
        <button name="commandName" value="browse_cube_volume_page_command">
            Куб
        </button>
    </form>
</div>
<div style="display: inline-block">
    <form method="post" action="controller">
        <button name="commandName" value="browse_sphere_volume_page_command">
            Сфера
        </button>
    </form>
</div>
<div style="display: inline-block">
    <form method="post" action="controller">
        <button name="commandName" value="browse_tetrahedron_volume_page_command">
            Тетраэдр
        </button>
    </form>
</div>
<div style="display: inline-block">
    <form method="post" action="controller">
        <button name="commandName" value="browse_torus_volume_page_command">
            Тор
        </button>
    </form>
</div>
<div style="display: inline-block">
    <form method="post" action="controller">
        <button name="commandName" value="browse_ball_volume_page_command">
            Шар
        </button>
    </form>
</div>
</body>
</html>
