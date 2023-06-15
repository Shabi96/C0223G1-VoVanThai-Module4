<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>CHANGE MONEY</title>
</head>
<body>
<form action="/change" method="post">
    <label>
        Nhập số tiền:
    </label>
    <input type="number" name="inputMoney"> USD<br>
    <label>
        Nhập tỉ giá:
    </label>
    <input type="number" name="rate"> VNĐ<br>
    <button type="submit">Tính</button>
    <p>Kết quả:
        <c:if test="${result < 0}">
            <span style="color: red">Bạn nhập thông tin chưa hợp lệ!!!</span>
        </c:if>
        <c:if test="${result >= 0}">
            ${result} VNĐ
        </c:if>
    </p>
</form>
</body>
</html>