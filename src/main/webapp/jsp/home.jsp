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
<h1>메인 페이지</h1>
<form method="get" action="/search">
    <h2>검색 범위</h2>
    <select name = "mainCategory" onchange="categoryChange(this)">
        <option value="none" selected>전체</option>
        <option value="department">부서</option>
        <option value="sex">성별</option>
        <option value="salary">연봉</option>
        <option value="bdate">생일</option>
        <option value="supervisor">부하직원</option>
    </select>

    <select name="subCategory" id = "category">
    </select>
    <input type = "text" name = "inputText">

    <script>
        function categoryChange(e){
            var none = [];
            var department = ["Research", "Administration", "Headquarters"];
            var sex = ["M", "F"];
            var target = document.getElementById("category");

            if(e.value == "department") var d = department;
            else if(e.value == "sex") var d = sex;
            else var d = none;

            target.options.length = 0;

            for (x in d) {
                var opt = document.createElement("option");
                opt.value = d[x];
                opt.innerHTML = d[x];
                target.appendChild(opt);
            }
        }
    </script>
    <h2>검색 항목</h2>
    <label><input type="checkbox" name="name" value="1" checked> Name</label>
    <label><input type="checkbox" name="ssn" value="1" checked> Ssn</label>
    <label><input type="checkbox" name="bdate" value="1" checked> Bdate</label>
    <label><input type="checkbox" name="address" value="1" checked> Address</label>
    <label><input type="checkbox" name="sex" value="1" checked> Sex</label>
    <label><input type="checkbox" name="salary" value="1" checked> Salary</label>
    <label><input type="checkbox" name="supervisor" value="1" checked> Supervisor</label>
    <label><input type="checkbox" name="department" value="1" checked> Department</label>
    <p><input type="submit" value="검색"></p>
</form>
<form method = "get" action = "/insertPage">
    <h2>직원 정보 추가</h2>
    <p><input type="submit" value="직원 정보 추가 페이지로 가기"></p>
</form>
</body>
</html>