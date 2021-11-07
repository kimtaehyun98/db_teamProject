<%@ page contentType="text/html; charset=utf-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>메인 페이지</h1>
<p>검색 범위</p>
<form>
    <select name="검색범위" id="selectBox1">
        <option value="none" selected>전체</option>
        <option value="department">부서</option>
        <option value="sex">성별</option>
        <option value="salary">연봉</option>
        <option value="bdate">생일</option>
        <option value="supervisor">부하직원</option>
    </select>
    // 이걸로 구글링하기 : Select box 특정 옵션 선택시 show/hide
    // https://truecode-95.tistory.com/47
    <select name="검색범위" id = "category">
        <option>조건 선택</option>
    </select>
    <input type = "text" name = "검색범위">
    <script>
        function categoryChange(e){
            let none = [];
            let department = ["Research", "Administration", "Headquarters"];
            let sex = ["M", "F"];
            let salary = [];
            let bdate = [];
            let supervisor = [];
        }
    </script>
</form>
<p>검색 항목</p>
<form method="get" action="/search">
    <label><input type="checkbox" name="name" value="NAME" checked> Name</label>
    <label><input type="checkbox" name="ssn" value="SSN" checked> Ssn</label>
    <label><input type="checkbox" name="bDate" value="BDATE" checked> Bdate</label>
    <label><input type="checkbox" name="address" value="ADDRESS" checked> Address</label>
    <label><input type="checkbox" name="sex" value="SEX" checked> Sex</label>
    <label><input type="checkbox" name="salary" value="SALARY" checked> Salary</label>
    <label><input type="checkbox" name="supervisor" value="SUPERVISOR" checked> Supervisor</label>
    <label><input type="checkbox" name="department" value="DEPARTMENT" checked> Department</label>
    <p><input type="submit" value="검색"></p>
</form>
</body>
</html>