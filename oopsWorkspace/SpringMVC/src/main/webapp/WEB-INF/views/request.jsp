<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
<head>
	<title>Request Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Request Management
</h1>
<c:url var="addAction" value="/user/login/request/${ownerId}/${ownerName}" ></c:url>
<c:url var="addAction" value="/request/add" ></c:url>

<form:form action="${addAction}" commandName="request">
<table>
	<tr>
		<td>
			<form:label path="requestId">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="requestId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="requestId" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="ownerId">
				<spring:message text="Owner ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="ownerId" readonly="true" size="8"  disabled="true" value="${ownerId}"/>
			<form:hidden path="ownerId"/>
		</td> 
	</tr>	<tr>
		<td>
			<form:label path="petType">
				<spring:message text="Pet Type"/>
			</form:label>
		</td>
		<td>
			<form:input path="petType" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="petName">
				<spring:message text="Pet Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="petName" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="petBreed">
				<spring:message text="Pet Breed"/>
			</form:label>
		</td>
		<td>
			<form:input path="petBreed" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="fromDate">
				<spring:message text="Date From"/>
			</form:label>
		</td>
		<td>
			<form:input path="fromDate" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="toDate">
				<spring:message text="Date To"/>
			</form:label>
		</td>
		<td>
			<form:input path="toDate" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="feedback">
				<spring:message text="Feedback"/>
			</form:label>
		</td>
		<td>
			<form:input path="feedback" />
		</td> 
	</tr>
	<tr>
		<td colspan="2">
			
				<input type="submit"
					value="<spring:message text="Add Request"/>" />
			
		</td>
	</tr>
</table>	
</form:form>
<br>
<c:set var="mystring" value="${type}"/>
<c:if test="${fn:substring(mystring, 0, 5) != 'Owner'}">
<h3>Request List</h3>
<form:form action="${addAction}" commandName="request">
	<table class="tg">
	<tr>
		<th width="80">Request ID</th>
		<th width="80">Owner ID</th>
		<th width="80">Pet Type</th>
		<th width="80">Pet Name</th>
		<th width="80">Pet Breed</th>
		<th width="80">Date From</th>
		<th width="80">Date To</th>
		<th width="80">Feedback</th>
		<th width="80">Valid Request</th>
		<th width="80">Request State</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
		<th width="60">Validate</th>
	</tr>
	<c:forEach items="${listRequest}" var="request">
		<tr>
			<td>${request.requestId}</td>
			<td>${request.ownerId}</td>
			<td>${request.petType}</td>
			<td>${request.petName}</td>
			<td>${request.petBreed}</td>
			<td>${request.fromDate}</td>
			<td>${request.toDate}</td>
			<td>${request.feedback}</td>
			<td>${request.validRequest}</td>
			<td>${request.requestState}</td>
			<td><a href="<c:url value='/update/${request.requestId}' />" >Edit</a></td>
			<td><a href="<c:url value='/delete/${request.requestId}' />" >Delete</a></td>
			<td><a href="<c:url value='/validate/${request.requestId}' />" >Validate</a></td>
		</tr>
	</c:forEach>
	</table>
</form:form>
</c:if>
</body>
</html>