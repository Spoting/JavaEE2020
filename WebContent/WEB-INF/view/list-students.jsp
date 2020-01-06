<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>List Students</title>
<!-- reference our style sheet -->
</head>
<body>
 <div id="container">
                <div id="content">
                        <!--  add our html table here -->
                        <table>
                                <tr>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Email</th>
                                </tr>
                                <!-- loop over and print our customers -->
                                <c:forEach var="tempCustomer" items="${students}">

                                        <tr>
                                                <td>${tempCustomer.firstName}</td>
                                                <td>${tempCustomer.lastName}</td>
                                                <td>${tempCustomer.email}</td>
                                        </tr>
                                </c:forEach>
                        </table>
                </div>
        </div>

</body>
</html>