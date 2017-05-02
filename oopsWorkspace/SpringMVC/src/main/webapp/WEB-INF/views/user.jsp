<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>User Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Login
</h1>

<c:url var="recoverAction" value="/user/recoverUsernamePassword" ></c:url>
<c:url var="loginAction" value="/user/login" ></c:url>

<form:form action="${loginAction}" commandName="user">


<table>
	<c:if test="${!empty user.username}">
	<tr>
		<td>
			<form:label path="userId">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="userId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="userId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="username">
				<spring:message text="Username"/>
			</form:label>
		</td>
		<td>
			<form:input path="username" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="password">
				<spring:message text="Password"/>
			</form:label>
		</td>
		<td>
			<form:input type="password" path="password" />
		</td>
	</tr>
	<tr>

		<td colspan="2">
			<c:if test="${empty user.username}">
				<input type="submit"
					value="<spring:message text="Login"/>" />
			</c:if>
	</tr>
	
	
</table>	
</form:form>

<form:form action="${recoverAction}" commandName="user">

				<input type="submit"
					value="<spring:message text="Forgot Username/Password"/>" />

</form:form>
<br>
<h3>Users List</h3>
<c:if test="${!empty listUsers}">
	<table class="tg">
	<tr>
		<th width="80">User ID</th>
		<th width="120">User Name</th>
		<th width="120">User Password</th>
	</tr>
	<c:forEach items="${listUsers}" var="user">
		<tr>
			<td>${user.userId}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
