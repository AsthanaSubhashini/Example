<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries --> 
	 <!--[if lt IE 9]>
	 	<script src="<c:url value="/static/iesupport/html5shiv.min.js" />"></script>
	 	<script src="<c:url value="/static/iesupport/respond.min.js" />"></script>
    <![endif]-->
    
</head>
<center>
<h2>Ewallet</h2></center>
<body>
	<form:form method="post" action="loginValidate" modelAttribute="loginData" >
		<center>
		<table style="background-color:#99ff99" width="30%" cellpadding="5">
		<thead>
		<tr>
		<th colspan="2">Login Here</th>
		</tr>
		</thead>
			<tbody align="center">
			<tr>
				<td>Username </td>
				<td><form:input type="text" name="username" required="required" autofocus="autofocus" path="username" /></td>
			</tr>
			<tr>
				<td>Password </td>
				<td><form:input type="password" name="password" required="required" autofocus="autofocus" path="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><input name="submit" type="submit" value="Login"> <input name="reset" type="reset" value="Reset"></td>
			</tr>
			</tbody>
		</table>
		</center>
	</form:form>

	<c:if test="${message ne null}">
		<p><b style="background-color: #ff6666"> <c:out value="${message}"/> </b></p>
	</c:if>
</body>
</html>