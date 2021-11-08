<%@ page contentType="text/html; charset=utf-8" language="java" %>
<html>
    <body>
        <h1>직원 정보 추가 페이지</h1>
        <form method="post" action="/insert">
            <p>새로운 직원 정보 추가</p>
            <label><input type = "text" name = "First Name"></label>
            <label><input type = "text" name = "Middle Init"></label>
            <label><input type = "text" name = "Last Name"></label>
            <label><input type = "text" name = "Ssn"></label>
            <label><input type = "text" name = "Birthdate"></label>
            <label><input type = "text" name = "Address"></label>
            <label><input type = "text" name = "Sex"></label>
            <label><input type = "text" name = "Salary"></label>
            <label><input type = "text" name = "Super_ssn"></label>
            <label><input type = "text" name = "Dno"></label>
            <p><input type="submit" value="정보 추가하기"></p>
        </form>
    </body>
</html>