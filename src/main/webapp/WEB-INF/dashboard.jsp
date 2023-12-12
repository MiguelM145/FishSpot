<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/dashboardStyle.css">
<title>Home</title>
</head>
<body>
	<div id="header" > 
		<h1>Welcome <c:out value="${user.userName }"/>!</h1>
		<a id="logout" href="/logout">Logout</a>
	</div>
	
		<br> 
		<br> 
		
		<div id="upper">
			<div class="iconAlign"> 
				<a href="/fishs/1"><img src="crappieicon.png" alt="crappie" class="fishIcon"> </a>
				<figcaption>Crappie</figcaption>
			</div>
			<div class="iconAlign">
				<a href="/fishs/2"><img src="bassicon.png" alt="bass" class="fishIcon"> </a>
				<figcaption>Bass</figcaption>
			</div>
			<div class="iconAlign">
				<a href="/fishs/3"><img src="catfishicon.png" alt="catfish" class="fishIcon"> </a>
				<figcaption>CatFish</figcaption>
			</div>
		</div>
		
		<div id="lower"> 
			<div class="iconAlign"> 
				<a href="/fishs/4"><img src="garicon.png" alt="gar" class="fishIcon"> </a>
				<figcaption>Gar</figcaption>
			</div>
			<div class="iconAlign">  
				<a href="/fishs/5"><img src="drumicon.png" alt="drum" class="fishIcon"> </a>
				<figcaption>Drum</figcaption>
			</div> 
			<div class="iconAlign"> 
				<a href="/fishs/6"><img src="bluegillicon.png" alt="bluegill" class="fishIcon"> </a>
				<figcaption>BlueGill</figcaption>
			</div> 
		</div>
		
</body>
</html>