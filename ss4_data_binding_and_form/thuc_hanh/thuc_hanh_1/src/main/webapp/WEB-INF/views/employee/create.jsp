<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 84912
  Date: 6/16/2023
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CREATE</title>
</head>
<body>
<h3>ADD NEW EMPLOYEE</h3>
<form:form method="post" action="/employee/create" modelAttribute="employee">
    <table>
        <tr>
            <th><form:label path="id">Employee ID: </form:label></th>
            <th><form:input path="id"/></th>
        </tr>
        <tr>
            <th><form:label path="name">Employee's Name: </form:label></th>
            <th><form:input path="name"/></th>
        </tr>
        <tr>
            <th><form:label path="contactNumber">Contact's Number: </form:label></th>
            <th><form:input path="contactNumber"/></th>
        </tr>
        <tr>
            <td><input type="submit" value="submit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
