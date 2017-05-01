<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
<head>
	<title>Add Contact Info</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<c:choose>
    <c:when test="${addContactInfo}">
       <h1>Add Contact Info</h1>
        <br />
    </c:when>    
    <c:when test="${editContactInfo}">
       <h1>Edit Contact Info</h1>
       <p>${id}</p>
        <br />
    </c:when>  
  
</c:choose>

	
	
<c:url var="addAction" value="/user/contactInfo/add" ></c:url>
<c:url var="editAction" value="/user/contactInfo/edit" ></c:url>
<c:url var="deleteAction" value="/user/contactInfo/remove" ></c:url>
<c:url var="redirectDash" value="/user/dash" ></c:url>


<form:form action="${addAction}" commandName="contactInfo">
<c:if test="${addContactInfo || editContactInfo}">
<table>
	
	<c:if test="${editContactInfo}">
	<tr>
		<td>
			<form:input path="id" value="${id}" readonly="true" size="8" type="hidden"/>
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>	
	
	<tr>
		<td>
			<form:input path="userId" value="${userId}" readonly="true" size="8" type="hidden" />
			<form:hidden path="userId" />
		</td> 
	</tr>	

	<tr>
		<td>
			<form:label path="street">
				<spring:message text="Street"/>
			</form:label>
		</td>
		<td>
		<c:choose>
    		<c:when test="${addContactInfo}">
			<form:input path="street"/>
    	</c:when>    
   		<c:when test="${editContactInfo}">
       		<form:input path="street" value="${street}"/>
    	</c:when>  	

		</c:choose>
  </td>
  
	</tr>
	
	<tr>
		<td>
			<form:label path="city">
				<spring:message text="City"/>
			</form:label>
		</td>
		<td>
		<c:choose>
    		<c:when test="${addContactInfo}">
			<form:input path="city"/>
    		</c:when>    
   		 	<c:when test="${editContactInfo}">
       		<form:input path="city" value="${city}"/>
    	</c:when>  

		</c:choose>
  </td>
		
	</tr>

	<tr>
		<td>
			<form:label path="state">
				<spring:message text="State"/>
			</form:label>
		</td>
		<td>
		<c:choose>
    		<c:when test="${addContactInfo}">
				<form:input path="state"/>
    		</c:when>    
   		 	<c:when test="${editContactInfo}">
     			 <form:input path="state" value="${state}"/>
    		</c:when>  
    	</c:choose>
    	</td>
	
	</tr>
	
	<tr>
		<td>
			<form:label path="phoneNumber">
				<spring:message text="Phone number"/>
			</form:label>
		</td>
		<td>
		<c:choose>
    		<c:when test="${addContactInfo}">
				<form:input path="phoneNumber"/>
    		</c:when>    
   		 	<c:when test="${editContactInfo}">
     			 <form:input path="phoneNumber" value="${phoneNumber}"/>
    		</c:when>  
    	</c:choose>
		</td>
	</tr>

		<tr>
		<td>
			<form:label path="zipcode">
				<spring:message text="Zipcode"/>
			</form:label>
		</td>
		<td>
		<c:choose>
    		<c:when test="${addContactInfo}">
				<form:input path="zipcode"/>
    		</c:when>    
   		 	<c:when test="${editContactInfo}">
     			 <form:input path="zipcode" value="${zipcode}"/>
    		</c:when>  
    	</c:choose>
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="emailAddr">
				<spring:message text="Email Address"/>
			</form:label>
		</td>
		<td>
		<c:choose>
    		<c:when test="${addContactInfo}">
				<form:input path="emailAddr"/>
    		</c:when>    
   		 	<c:when test="${editContactInfo}">
     			 <form:input path="emailAddr" value="${emailAddr}"/>
    		</c:when>  
    	</c:choose>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
		<c:if test="${addContactInfo}">
		<button id="button1">Submit</button>
		</c:if>
		</td>
		<c:if test="${editContactInfo}">
		<input type="submit"	
		value="<spring:message text="Edit Contact Info"/>" />
		</c:if>
	</tr>
</table>
</c:if>

</form:form>
<c:if test="${!empty invalidInput}">
	<p>${invalidInput}</p></c:if>

<br>
<h3>Your Contact Info</h3>

<c:if test="${!empty listContactInfo}">
	<table class="tg">
	<tr>
		<th width="120">Street</th>
		<th width="120">City</th>
		<th width="120">State</th>
		<th width="120">Phone Number</th>
		<th width="120">Zipcode</th>
		<th width="120">Email Address</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listContactInfo}" var="contactInfo">
		
		
		<tr>
		 	<td>${contactInfo.street}</td>
			<td>${contactInfo.city}</td>
			<td>${contactInfo.state}</td>
			<td>${contactInfo.phoneNumber}</td>
			<td>${contactInfo.zipcode}</td>
			<td>${contactInfo.emailAddr}</td>
			<!--  <td><a href="<c:url value='/user/contactInfo/edit/${contactInfo.id}/${contactInfo.userId}/${contactInfo.street}/${contactInfo.city}/
			${contactInfo.state}/${contactInfo.phoneNumber}/${contactInfo.zipcode}/${contactInfo.emailAddr}'/>" >Edit</a></td>
			<td><a href="<c:url value='/user/contactInfo/remove/${contactInfo.id}/${contactInfo.userId}' />" >Delete</a></td>
		 -->
		 <td>
		 <form:form action="${editAction}" commandName="contactInfo">
			<form:input path="id" value="${id}" readonly="true" size="8" type="hidden"/>
			
			<form:input path="userId" value="${userId}" readonly="true" size="8" type="hidden"/>
			
			<form:input path="street" value="${street}" readonly="true" size="8" type="hidden"/>
			
			<form:input path="city" value="${city}" readonly="true" size="8" type="hidden"/>

			<form:input path="state" value="" readonly="true" size="8" type="hidden"/>
		
			<form:input path="phoneNumber" value="${phoneNumber}" readonly="true" size="8" type="hidden"/>
			
			<form:input path="zipcode" value="${zipcode}" readonly="true" size="8" type="hidden"/>
		
			<form:input path="emailAddr" value="${emailAddr}" readonly="true" size="8" type="hidden"/>
		 
			<input type="submit"	
			value="<spring:message text="Edit"/>" />
			</form:form>
			</td>
			 <td>
		 <form:form action="${deleteAction}" commandName="contactInfo">
			<form:input path="id" value="${id}" readonly="true" size="8" type="hidden"/>
			
			<form:input path="userId" value="${userId}" readonly="true" size="8" type="hidden"/>
			
			<form:input path="street" value="${street}" readonly="true" size="8" type="hidden"/>
			
			<form:input path="city" value="${city}" readonly="true" size="8" type="hidden"/>

			<form:input path="state" value="" readonly="true" size="8" type="hidden"/>
		
			<form:input path="phoneNumber" value="${phoneNumber}" readonly="true" size="8" type="hidden"/>
			
			<form:input path="zipcode" value="${zipcode}" readonly="true" size="8" type="hidden"/>
		
			<form:input path="emailAddr" value="${emailAddr}" readonly="true" size="8" type="hidden"/>
		 
			<input type="submit"	
			value="<spring:message text="Delete"/>" />
			</form:form>
			</td>
			</tr>
	</c:forEach>
	</table>
</c:if>
 <form:form action="${redirectDash}" commandName="contactInfo">
		
			<form:input path="userId" value="${userId}" readonly="true" size="8" type="hidden"/>
		 
			<input type="submit"	
			value="<spring:message text="Go back to dashboard"/>" />
</form:form>

			
</body>
</html>