<%@ page contentType="text/html; charset=utf-8" language="java" %>
<script type="text/javascript" src="src/main/webapp/js/home.js"></script>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>메인 페이지</h1>
<form method="get" action="/search">
    <p>검색 범위</p>
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
    <p>검색 항목</p>
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
</body>
</html>