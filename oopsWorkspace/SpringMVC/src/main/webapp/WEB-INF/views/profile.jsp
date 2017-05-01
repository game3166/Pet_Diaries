<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
<head>
	<title>Profile</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<p>${firstName}'s Profile</p> 

<p> My Pet Preferences </p>

<c:if test="${!empty listPetPreferences}">
	<table class="tg">
	<tr>

		<th width="120">Pet Type</th>
		<th width="120">Pet Breed</th>
		<th width="120">Pet Size</th>

	</tr>
	<c:forEach items="${listPetPreferences}" var="pet">
		<tr>
			<td>${pet.petType}</td>
			<td>${pet.petBreed}</td>
			<td>${pet.petSize}</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<p> I live near ${listContact.state}, ${listContact.city}</p>
			
</body>
</html>