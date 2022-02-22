<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Создание обсуждения</h1>
<form id="form"  action="<c:url value='/save'/>" method='POST'>
    <table>
        <tr>
            <td>Тема:</td>
            <td><input type='text' name='name' required></td>
        </tr>
        <tr>
            <td>Описание обсуждения:</td>
            <td><input type='text' name='description' required></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</body>
</html>