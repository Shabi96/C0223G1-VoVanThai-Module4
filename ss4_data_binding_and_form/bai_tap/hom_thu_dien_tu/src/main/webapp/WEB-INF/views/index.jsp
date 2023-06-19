<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mail Box</title>
    <style>
        th {
            text-align: left;
        }
    </style>
</head>
<body>
<h2>Settings</h2>
<form:form method="post" action="/update" modelAttribute="mail">
    <table style="font-size: large">
        <tr>
            <th><form:label path="languages">Languages: </form:label></th>
            <th>
                <form:select path="languages" items="${languages}"/>
            </th>
        </tr>
        <tr>
            <th><form:label path="pageSize">Page Size: </form:label></th>
            <th>
                Show <form:select path="pageSize" items="${pageSize}"/>
                emails per page
            </th>
        </tr>
        <tr>
            <th><form:label path="filter">Spams filter: </form:label></th>
            <th><form:checkbox path="filter" value="true"/>Enable spams filter</th>
        </tr>
        <tr>
            <th><form:label path="signature">Signature: </form:label> </th>
            <th>
                <form:textarea path="signature"/>
            </th>
        </tr>
        <tr>
            <th></th>
            <th>
                <form:button>Update</form:button>
                <a><button type="reset">Cancel</button></a>
            </th>
        </tr>
    </table>
</form:form>
</body>
</html>