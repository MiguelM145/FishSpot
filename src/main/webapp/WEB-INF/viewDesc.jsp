<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/viewStyle.css">
<title>Catches</title>
</head>
<body>
	<div id="header">
		<a href="/dashboard" id="dash">Dashboard</a>
		
		<a href="/logout" id="logout">Logout</a>
	</div>
		<div id="containerFish">
				<h4>Hover over fish image to share catch!</h4>
			<table>
				<tr>
					<th>
						<c:if test="${fish.fish.id == 1}">
							<img src="/crappieicon.png" alt="crappie"  class="fishIcon">
						</c:if>
						<c:if test="${fish.fish.id == 2}">
							<img src="/bassicon.png" alt="bass" class="fishIcon">
						</c:if>
						<c:if test="${fish.fish.id == 3}">
							<img src="/catfishicon.png" alt="catfish" class="fishIcon">
						</c:if>
						<c:if test="${fish.fish.id == 4}">
							<img src="/garicon.png" alt="gar" class="fishIcon">			
						</c:if>
						<c:if test="${fish.fish.id == 5}">
							<img src="/drumicon.png" alt="drum" class="fishIcon">
						</c:if>
						<c:if test="${fish.fish.id == 6}">
							<img src="/bluegillicon.png" alt="bluegill" class="fishIcon">
						</c:if>
							   Name</th>
					<th>Area Caught</th>
					<th>Time Caught</th>
				</tr>
				
						<tr>
							<td><c:out value="${fish.user.userName}" /></td>
							<td><a id="link" href="/fishs/${fish.fish.id}"><c:out value="${fish.areaCaught}" /> (click to return)</a></td>
							<td><c:out value="${fish.timeOfDay}" /></td>
						</tr>
						<tr>
							<td rowspan="3" colspan="3" ><span style="width: 1100px;"><c:out value="${fish.description}" /></span></td>
						</tr>
			</table>
		
		
		<div id="manage">
				<c:if test="${loggedUser.id.equals(fish.user.id)}">
				  <a class="manageBut" href="/fishs/edit/${fish.id}">Edit Catch</a>
				
				<a class="manageBut" href="/fishs/delete/${fish.id}">Delete Catch</a>
				</c:if>
			</div>
		</div>
</body>
</html>