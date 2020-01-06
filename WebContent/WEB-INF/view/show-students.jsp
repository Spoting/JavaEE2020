<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Activate Students</title>

</head>
<body>
<form action="activateStudent" method="GET">
<input type="number" name="studentId" placeholder="ActivateStudent"/>
<input type="submit" />

</form>
<!-- H LISTA ME TOUS STUDENTS -->
<ul>
    <c:forEach var="listValue" items="${studentList}">
        <li><c:out value="${listValue}"></c:out></li>
    </c:forEach>
</ul>
<a>
<!-- TO MESSAGE -->
${message} 
</a>
</body>
</html>
