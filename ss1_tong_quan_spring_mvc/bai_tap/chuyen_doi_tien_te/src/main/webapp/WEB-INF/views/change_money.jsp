<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>CHANGE MONEY</title>
</head>
<body>
<form action="/money" method="post">
    <label>
        Nhập số tiền:
    </label>
    <input type="text" name="inputMoney"> USD<br>
    <label>
        Nhập tỉ giá:
    </label>
    <input type="text" name="rate"> VNĐ<br>
    <button type="submit">Tính</button>
    <p id="result">Kết quả: ${result} VNĐ</p>
</form>
</body>
</html>