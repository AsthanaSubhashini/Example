<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<c:if test="${isCreate ne null}">
		<title>Create User</title>
	</c:if>
	
	<c:if test="${isUpdate ne null}">
		<title>Update User</title>
	</c:if>
	
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries --> 
	 <!--[if lt IE 9]>
	 	<script src="<c:url value="/static/iesupport/html5shiv.min.js" />"></script>
	 	<script src="<c:url value="/static/iesupport/respond.min.js" />"></script>
    <![endif]-->
	
</head>
<body onload="loadActiveDays()">
	<c:if test="${isCreate ne null}">
		<h1>Create User:</h1>
		<c:set var="formAction" value="createUser"/>
	</c:if>
	
	<c:if test="${isUpdate ne null}">
		<h1>Update User:</h1>
		<c:set var="formAction" value="updateUser"/>
	</c:if>

	<form:form method="post" action="${formAction}" modelAttribute="ewalletUserData" onsubmit="getActiveDays()" >
		<table>
			<tbody>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" type="text" size="68" required="required" autofocus="autofocus"/></td>
				</tr>
				
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" type="text" size="68" required="required" autofocus="autofocus"/></td>
				</tr>
				
				<tr>
					<td>Organization</td>
					<td><form:input path="organization" type="text" size="68" required="required" autofocus="autofocus"/></td>
				</tr>
				
				<tr>
					<td>Password</td>
					<td><form:input path="password" type="password" size="68" required="required" autofocus="autofocus"/></td>
				</tr>
				
				<tr>
					<td>Customer ID</td>
					<td><form:input path="customerId" type="text" size="68" required="required" autofocus="autofocus" pattern="[0-9]{0-6}" title="Number code, Maxlength-6"/></td>
				</tr>
				
				<tr>
					<td>Card Number</td>
					<td><form:input path="cardNumber" type="text" size="68" required="required" autofocus="autofocus" pattern="[0-9]" title="16-digit Card Number" /></td>
				</tr>
				
				<tr>
					<td>Active Status</td>
					<td><form:input path="activeStatus" type="text" size="68" required="required" autofocus="autofocus"/></td>
				</tr>
				
				<tr>
					<td>Email ID</td>
					<td><form:input path="emailId" type="email" size="68" required="required" autofocus="autofocus"/></td>
				</tr>
				
				<tr>
					<td>Mobile No.</td>
					<td><form:input path="mobileNo" type="text" maxlength="10" size="68" required="required" autofocus="autofocus" pattern="[0-9]{10}" title="10 Digit Mobile number"/></td>
				</tr>
				
				<tr>
					<td>Active Days</td>
					<td>
						<input type="checkbox" name="cb"/>
						<input type="checkbox" name="cb" />
						<input type="checkbox" name="cb" />
						<input type="checkbox" name="cb" />
						<input type="checkbox" name="cb" />
						<input type="checkbox" name="cb" />
						<input type="checkbox" name="cb" />
						
						<form:input path="activeDays" id="activeDays" type="hidden" />
					</td>
				</tr>
				
				<tr>
					<td><input name="submit" type="submit" value="Submit"></td>
				</tr>
				
			</tbody>
		</table>
	</form:form>
	
	<c:if test="${message ne null}">
		<p><b style="background-color: #ff6666"> <c:out value="${message}"/> </b></p>
	</c:if>
	
	<script type="text/javascript">
		function loadActiveDays(){
			var activeDays = document.getElementById("activeDays").value;
			document.getElementById("activeDays").value = "";
			activeDays = activeDays.replace(/\|/g, ""); // Replaces '|' with ''
			
			var cb = document.getElementsByName("cb");
			for(i = 0; i < cb.length; i++){
				if(activeDays.charAt(i) == '1')
					cb[i].checked = true;
				else
					cb[i].checked = false;
			}
		}
	
		function getActiveDays(){
			var activeDays = "";
			var cb = document.getElementsByName("cb");
			
			for(i = 0; i < cb.length; i++){
				if(cb[i].checked){
					activeDays = activeDays + "1"; 
				}else{
					activeDays = activeDays + "0";
				}
				
				if(i != 6)
					activeDays = activeDays + "|";
			}
			
			document.getElementById("activeDays").value = activeDays;
		}
		
	</script>
</body>
</html>