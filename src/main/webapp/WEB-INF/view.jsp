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
						<c:if test="${id == 1}">
							<a href="/fishs/new/1"><img src="/crappieicon.png" onmouseover="this.src='/addcatch.png';" onmouseout="this.src='/crappieicon.png';" alt="crappie"  class="fishIcon"></a>
						</c:if>
						<c:if test="${id == 2}">
							<a href="/fishs/new/2"><img src="/bassicon.png" onmouseover="this.src='/addcatch.png';" onmouseout="this.src='/bassicon.png';" alt="bass" class="fishIcon"></a>
						</c:if>
						<c:if test="${id == 3}">
							<a href="/fishs/new/3"><img src="/catfishicon.png" onmouseover="this.src='/addcatch.png';" onmouseout="this.src='/catfishicon.png';" alt="catfish" class="fishIcon"></a>
						</c:if>
						<c:if test="${id == 4}">
							<a href="/fishs/new/4"><img src="/garicon.png" onmouseover="this.src='/addcatch.png';" onmouseout="this.src='/garicon.png';" alt="gar" class="fishIcon"></a>				
						</c:if>
						<c:if test="${id == 5}">
							<a href="/fishs/new/5"><img src="/drumicon.png" onmouseover="this.src='/addcatch.png';" onmouseout="this.src='/drumicon.png';" alt="drum" class="fishIcon"></a>
						</c:if>
						<c:if test="${id == 6}">
							<a href="/fishs/new/6"><img src="/bluegillicon.png" onmouseover="this.src='/addcatch.png';" onmouseout="this.src='/bluegillicon.png';" alt="bluegill" class="fishIcon"></a> 
						</c:if>
							   Name</th>
					<th>Area Caught</th>
					<th>Time Caught</th>
				</tr>
				<c:forEach var="fish" items="${fish}">
					<c:if test="${fish.fish.id == id}">
						<tr>
							<td>${fish.user.userName}</td>
							<td><a id="link" href="/fishs/desc/${fish.id }">${fish.areaCaught} (Click To Expand)</a></td>
							<td>${fish.timeOfDay}</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		
			</div>
</body>
</html>