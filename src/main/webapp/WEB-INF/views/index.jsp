<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Forum</title>
</head>
<body>
<h1 align="center">Форум</h1>
<c:if test="${user == null}">
    <div align="center">
        <a href="<c:url value='/reg'/>" style="color: black">Регистрация</a>
        <a href="<c:url value='/login'/>" style="color: black">Авторизация</a>
    </div>
</c:if>
<c:if test="${user != null}">
    <div style="color:#131313;" align="center">
        Ваше имя - <strong>${user.username}</strong>
        <br><a href="<c:url value='/logout'/>"><font color="black">Выйти из аккаунта</font></a>
    </div>
</c:if>
    <table class="table" style="width: 80%;" align="center">
        <thead>
        <tr>
            <th scope="col">Дата создания</th>
            <th scope="col">Название</th>
            <th scope="col">Содержание</th>
            <th scope="col">Изменить обсуждение</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td>
                    <c:out value="${post.created}"/>
                </td>
                <td>
                    <c:out value="${post.name}"/>
                </td>
                <td>
                    <c:out value="${post.description}"/>
                </td>
                <td>
                    <a href="<c:url value="/edit?id=${post.id}"/>" style="color: black">&#9988</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<div align="center"><a href="<c:url value='/create'/>"><font size="4" color="black">Добавить обсуждение</font></a></div>
</body>
</html>