<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Credit Balance</title>
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries --> 
	 <!--[if lt IE 9]>
	 	<script src="<c:url value="/static/iesupport/html5shiv.min.js" />"></script>
	 	<script src="<c:url value="/static/iesupport/respond.min.js" />"></script>
    <![endif]-->
	
</head>
<body>
	<h1>Credit Balance:</h1>
	
	<form:form method="post" action="creditbalance" modelAttribute="ewalletCreditBalData" >
		<table>
			<tbody>
				<tr>
					<td>Customer ID</td>
					<td><form:input path="customerId" type="text" size="68" required="required" autofocus="autofocus" pattern="[0-9]{0-6}" title="Number code, Maxlength-6"/></td>
				</tr>
				
				<tr>
					<td>Card Number</td>
					<td><form:input path="cardNumber" type="text" size="68" required="required" autofocus="autofocus" /></td>
				</tr>
				
				<tr>
					<td>Admin User</td>
					<td><form:input path="adminUser" type="text" size="68" required="required" autofocus="autofocus"/></td>
				</tr>
				
				<tr>
					<td>txnAmount</td>
					<td><form:input path="txnAmount" type="text" size="68" required="required" autofocus="autofocus"/></td>
				</tr>
				
				
				
				<tr>
					<td><input name="submit" type="submit" value="Submit"></td>
					<td><input name="submit" type="button" value="Cancel" onClick="location.href='<c:url value="/index.jsp"/>'"/></td>
				</tr>
				
			</tbody>
		</table>
	</form:form>
	
	<c:if test="${message ne null}">
		<p><b style="background-color: #ff6666"> <c:out value="${message}"/> </b></p>
	</c:if>
	<%-- 
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
		
	</script> --%>
</body>
</html>