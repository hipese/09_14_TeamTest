<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact List</title>
</head>
<body>
	
	  <table border="1" align="center">
        <thead>
            <tr>
                <th colspan="3">데이터 목록</th>
            </tr>
            <tr>
            	<th>seq</th>
            	<th>name</th>
            	<th>contact</th>
            </tr>
        </thead>
        
        
        	<c:forEach var="i" items="${list}" >
        	<tr>
        		<td>${i.seq }</td>
        		<td>${i.name }</td>
        		<td>${i.contact }</td>
        	</tr>
        	</c:forEach>
        	
        	
        	
            <form action="Delete.contacts" method="get">
                <tr>
                    <td colspan="2"><input type="text" name="seq" placeholder="삭제할 아이디를 입력하세요"></td>
                    <td><button>삭제</button></td>
                </tr>
                
            </form>

            <form action="Update.contacts" method="get">
                <tr>
                    <td colspan="3"><input type="text" name="name" placeholder="변경하고 싶은 이름을 입력하세요"></td>
                </tr>

                <tr>
                    <td colspan="3"><input type="text" name="tel" placeholder="변경하고 싶은연락처를 입력하세요"></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="text" name="seq" placeholder="변경할 아이디를 입력하세요"></td>
                    <td><button>변경</button></td>
                </tr>
            </form>
        	
    </table>

</body>
</html>