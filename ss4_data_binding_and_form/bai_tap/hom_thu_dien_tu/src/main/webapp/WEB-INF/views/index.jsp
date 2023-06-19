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
    <table>
        <tr>
            <th><form:label path="languages">Languages: </form:label></th>
            <th><form:select path="languages">
                    <form:option value="English" label="English"/>
                    <form:option value="Vietnamese" label="Vietnamese"/>
                    <form:option value="Japanese" label="Japanese"/>
                    <form:option value="Chinese" label="Chinese"/>
                </form:select>
            </th>
        </tr>
        <tr>
            <th><form:label path="pageSize">Page Size: </form:label></th>
            <th>
                Show <form:select path="pageSize">
                        <form:option value="5">5</form:option>
                        <form:option value="10">10</form:option>
                        <form:option value="15">15</form:option>
                        <form:option value="25">25</form:option>
                        <form:option value="50">50</form:option>
                        <form:option value="100">100</form:option>
                    </form:select>
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