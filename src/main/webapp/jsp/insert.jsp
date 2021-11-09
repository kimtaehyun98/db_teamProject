<%@ page contentType="text/html; charset=utf-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>DB_706_11</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <style>
        *{
            font-family: 'Jua', sans-serif;
        }
    </style>
</head>
    <body>
        <h1>직원 정보 추가 페이지</h1>
        <form method="post" action="/insert">
            <p>새로운 직원 정보 추가</p>
            <label>First Name : <input type = "text" name = "fname"></label><br>
            <label>Middle Init : <input type = "text" name = "minit"></label><br>
            <label>Last Name : <input type = "text" name = "lname"></label><br>
            <label>Ssn : <input type = "text" name = "ssn"></label><br>
            <label>Birthdate : <input type = "text" name = "bdate"></label><br>
            <label>Address : <input type = "text" name = "address"></label><br>
            <label>Sex : <input type = "text" name = "sex"></label><br>
            <label>Salary : <input type = "text" name = "salary"></label><br>
            <label>Super_ssn : <input type = "text" name = "super_ssn"></label><br>
            <label>Dno : <input type = "text" name = "dno"></label><br>
            <p><input type="submit" value="정보 추가하기"></p>
        </form>
    </body>
</html>