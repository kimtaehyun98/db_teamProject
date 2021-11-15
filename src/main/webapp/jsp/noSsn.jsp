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
<h1>Ssn 정보가 없어서 UPDATE, DELETE에 실패하였습니다!</h1>
<form method="get" action="/">
    <p>UPDATE, DELETE 작업을 수행하려면 반드시 검색 항목에서 Ssn 정보를 검색해야 가능합니다.</p><br>
    <p>이유 : Ssn이 EMPLOYEE 테이블의 PK이기 때문입니다.</p><br>
    <p>따라서 UPDATE, DELETE 작업을 원하시면 Ssn을 검색 항목에 추가한 뒤 실행시켜주시기 바랍니다.</p><br>
    <br>
    <input type="submit" value="메인 화면으로 돌아가기">
</form>
</body>
</html>