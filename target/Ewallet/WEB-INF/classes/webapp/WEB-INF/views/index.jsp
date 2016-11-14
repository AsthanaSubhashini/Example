<!-- JSTL tags  -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ewallet</title>
</head>
<body>
	<h1>Ewallet</h1>
	<h3><a href="<c:url value="/create"/>">Create</a></h3>
	<h3><a href="<c:url value="/update"/>">Update</a></h3>
	<h3><a href="<c:url value="/creditbal"/>">Credit Balance</a></h3>
	
	<c:if test="${message ne null}">
		<p><b style="background-color: #66ffc2"> <c:out value="${message}"/> </b></p>
	</c:if>
</body>
</html>