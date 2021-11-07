<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file = "home.jsp" %>
<%@ page import ="java.util.*" %>
<%@ page import ="java.lang.*" %>
<%@ page import ="com.db.db_teamproject.model.Search" %>
<%@ page import="java.sql.ResultSet" %>

<%!
    ArrayList<Boolean> check;
    ArrayList<Search> employees;
    ArrayList<String> tableHeaders;
%>
<%
    check = (ArrayList<Boolean>) request.getAttribute("check");
    employees = (ArrayList<Search>) request.getAttribute("employees");
    tableHeaders = (ArrayList<String>) request.getAttribute("tableHeaders");
%>
<h1>검색 테이블 출력</h1>
<form method = "post" action="/delete">
    <table border = "1">
        <th>선택</th>
        <%
            for(int i = 0; i < tableHeaders.size(); i++){
        %>
        <th><%=tableHeaders.get(i)%></th>
        <%
            }
        %>
        <%
            for(int i=0;i<employees.size();i++){
        %>
        <tr>
            <td><label><input type="checkbox" name = "<%=employees.get(i).getName()%>" value="<%=employees.get(i).getSsn()%>" onchange="viewName(this)"></label></td>
            <%
                if(check.get(0)) {
            %>
            <td><%=employees.get(i).getName()%></td>
            <%
                }
                if(check.get(1)) {
            %>
            <td><%=employees.get(i).getSsn()%></td>
            <%
                }
                if(check.get(2)) {
            %>
            <td><%=employees.get(i).getBDate()%></td>
            <%
                }
                if(check.get(3)) {
            %>
            <td><%=employees.get(i).getAddress()%></td>
            <%
                }
                if(check.get(4)) {
            %>
            <td><%=employees.get(i).getSex()%></td>
            <%
                }
                if(check.get(5)) {
            %>
            <td><%=employees.get(i).getSalary()%></td>
            <%
                }
                if(check.get(6)) {
            %>
            <td><%=employees.get(i).getSupervisor()%></td>
            <%
                }
                if(check.get(7)) {
            %>
            <td><%=employees.get(i).getDepartment()%></td>
            <%
                }
            %>
        </tr>
        <%
            }
        %>
    </table>
    <p><input type="submit">삭제</p>
</form>
<script>
    function viewName(e){
        console.log(e.value);
        // 데이터 출력
        document.getElementById('selectEmployee').innerText
            = e.value + "     ";
    }
</script>
<h2>선택한 직원</h2>
<div id='selectEmployee'></div>