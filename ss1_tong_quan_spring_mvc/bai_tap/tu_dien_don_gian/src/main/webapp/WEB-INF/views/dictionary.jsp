<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>TRANSLATE</title>
</head>
<body>
<form action="/translate" method="post">
    <h3>Dictionary</h3>
    <label>
        Nhập từ cần dịch:
    </label>
    <input type="text" name="word">
    <button type="submit">Dịch</button>
    <p>Kết quả: <span style="color: blue">${result}</span></p>
</form>
</body>
</html>