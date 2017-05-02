<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Password Recovery</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Recover your password
</h1>

<c:url var="updateAction" value="/user/updatePassword" ></c:url>

<form:form action="${updateAction}" commandName="user">

<c:if test="${!success}">
<table>
	
	<tr>	
		<td>
			<form:input path="userId" value="${user.userId}" readonly="true" size="8" hidden="true"/>
		
			<form:input path="firstName" value="${user.firstName}" readonly="true" size="8" hidden="true"/>
			
			<form:input path="lastName" value="${user.lastName}" readonly="true" size="8" hidden="true"/>
		
			
			<form:label path="password">
				<spring:message text="Enter Password"/>
			</form:label>
		
			<form:input type="password" path="password" />
				
			<form:input path="userType" value="${user.userType}" readonly="true" size="8" hidden="true"/>
			<form:input path="username" value="${user.username}" readonly="true" size="8" hidden="true"/>
		</td>

	</tr>
	
	<tr>

		<td colspan="2">

				<input type="submit"
					value="<spring:message text="Submit"/>" />
	</td>
	</tr>
	
	
</table>	
</c:if>
</form:form>


<c:if test="${success}">
<h1>Password reset</h1>
<p>Go to Login page </p>
  <form:form method = "GET" action = "/SpringMVC/login">
         <table>
            <tr>
            <td>Go back to login</td>
               <td>
                   <td><a href="goToLogin">Login</a>
               </td>
            </tr>
         </table>  
      </form:form>
</c:if>
</body>
</html>
