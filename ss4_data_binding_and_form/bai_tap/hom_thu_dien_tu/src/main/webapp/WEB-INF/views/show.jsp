<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 84912
  Date: 6/19/2023
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Mail Box</title>
    <style>
        th {
            text-align: left;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2 style="color: blue">Configuration</h2>
<form>
    <table class="table" style="width: 50%; border: 1px">
        <tr>
            <th>Languages: </th>
            <th>${mail.languages}</th>
        </tr>
        <tr>
            <th>Page Size: </th>
            <th>${mail.pageSize}</th>
        </tr>
        <tr>
            <c:if test="${mail.filter == true}">
                <th>Spams filter: </th>
                <th>Enable</th>
            </c:if>
            <c:if test="${mail.filter == false}">
                <th>Spams filter: </th>
                <th>Disable</th>
            </c:if>
        </tr>
        <tr>
            <th>Signature: </th>
            <th>${mail.signature}</th>
        </tr>
    </table>
</form>
<a href="/setting"><button>Setting</button></a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
