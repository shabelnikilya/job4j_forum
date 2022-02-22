<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Редактирование нарушения</h1>
<form id="form"  action="<c:url value='/update?id=${post.id}'/>" method='POST'>
    <table>
        <tr>
            <td>Тема:</td>
            <td><input type='text' name='name' value="${post.name}" required></td>
        </tr>
        <tr>
            <td>Обсуждение:</td>
            <td><input type='text' name='description' value="${post.description}" required></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Изменить"/></td>
        </tr>
    </table>
</form>
</body>
</html>